try {
        URL url  = new URL("https://www.visruthcv.appspot.com");
        URLConnection con = url.openConnection();

        HttpURLConnection httpUrlConnection = (HttpURLConnection) con;
        httpUrlConnection.setReadTimeout(10000);
        httpUrlConnection.setConnectTimeout(15000);
        httpUrlConnection.setRequestMethod("POST");
        httpUrlConnection.setDoInput(true);
        httpUrlConnection.setDoOutput(true);

        /*
         * for request headers
         */
        httpUrlConnection.setRequestProperty("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpUrlConnection.setRequestProperty("Accept-Charset",
                "ISO-8859-1,utf-8;q=0.7,*;q=0.3");
        httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
        httpUrlConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.8");
        httpUrlConnection.setRequestProperty("Connection", "keep-alive");


        /*
         * for adding request parameters
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", "Visruth");
        params.put("password", "passwd");

        OutputStream os = httpUrlConnection.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
        writer.write(getQuery(params));
        writer.flush();
        writer.close();
        os.close();

        httpUrlConnection.connect();

        // To write to a file, something like this
        InputStream is = httpUrlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("/home/visruth/Desktop/photo2.jpg");
        int i = 0;
        byte[] b = new byte[1024];

        while((i = is.read(b)) != -1) {
            fos.write(b, 0, i);
        }

    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (ProtocolException e) {
        e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }