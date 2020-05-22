URL url = new URL("https://dev.in/rest/service/create");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");

        conn.setRequestProperty("Accept", "application/json;ver=1.0");
        conn.setRequestProperty("username", "raj");
        conn.setRequestProperty("password", "raj");

        String input = "{}" ; //set you json payload here.          
        OutputStream os = conn.getOutputStream();
        os.write(input.getBytes());

        os.flush();        
        conn.disconnect();