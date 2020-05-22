try{
String url = "https://SERVER-ADDRESS:PORT/site/login?username=" + user + "&password=" + password;
HttpParams params = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(params, 1000 * 60 * 2);
        HttpConnectionParams.setSoTimeout(params, 0);
        HttpClient httpClient = new DefaultHttpClient(params);

        //prepare the HTTP GET call 
        HttpGet httpget = new HttpGet(url);
        //get the response entity
        HttpEntity entity = httpClient.execute(httpget).getEntity();

        if (entity != null) {
            //get the response content as a string
            String response = EntityUtils.toString(entity);
            //consume the entity
            entity.consumeContent();

            // When HttpClient instance is no longer needed, shut down the connection manager to ensure immediate deallocation of all system resources
            httpClient.getConnectionManager().shutdown();
           }
    }catch (Exception e) {
        e.printStackTrace();
    }