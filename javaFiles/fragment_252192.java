try {

        InputStream is = new URL(url).openStream();
        BufferedReader rd = new BufferedReader(
                    new InputStreamReader(is, Charset.forName("UTF-8")));
        try {
        String json = rd.readLine();
        } finally {
            rd.close();
        }
        }  catch (Exception e) {
            System.out.println(e.toString());
        } 

JSONObject obj = new JSONObject(json);