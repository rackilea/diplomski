Authenticator.setDefault(new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("user", "pass".toCharArray());
        }
    });
    String uri = "http://127.0.0.1:8332";
    String requestBody = "{\"jsonrpc\":\"2.0\",\"id\":\"1\",\"method\":\"getbalance\"}";
    String contentType = "application/json";
    HttpURLConnection connection = null;
    try {
        URL url = new URL(uri);
        connection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", contentType);
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Length", Integer.toString(requestBody.getBytes().length));
        connection.setUseCaches(true);
        connection.setDoInput(true);
        OutputStream out = connection.getOutputStream();
        out.write(requestBody.getBytes());
        out.flush();
        out.close();
    } catch (IOException ioE) {
        connection.disconnect();
        ioE.printStackTrace();
    }

    try {
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            System.out.println(response);
        } else {
            connection.disconnect();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }