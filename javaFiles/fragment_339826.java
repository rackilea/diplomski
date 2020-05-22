SSLContext sc = null;
    HttpsURLConnection conn = null;

    try {
        URL httpsURL = new URL(urlString);
        sc = SSLContext.getInstance("TLSv1.2");
        sc.init(null, null, new java.security.SecureRandom());
        conn  = (HttpsURLConnection) httpsURL.openConnection();
        conn.setSSLSocketFactory(sc.getSocketFactory());

        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
        osw.write(dataString);
        osw.flush();
        osw.close();
        os.close();
        conn.connect();

        if(conn.getResponseCode() != 200)
            throw new MyServerException();

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output;
        StringBuilder sb = new StringBuilder();

        while ((output = br.readLine()) != null) {
            sb.append(output);
        }

        if(conn != null)
            conn.disconnect();

        return sb.toString();
    }
    catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    catch (KeyManagementException e) {
        e.printStackTrace();
    }
    catch (MalformedURLException e) {
        e.printStackTrace();
    }
    catch (IOException e) {
        e.printStackTrace();
    }

    if(conn != null)
        conn.disconnect();

    throw new MyServerException();