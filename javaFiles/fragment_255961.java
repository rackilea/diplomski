public String post(String str) {
        String result = "";
        try {
            HttpParams httpParameters = new BasicHttpParams();
            int timeoutConnection = 3000;
            HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
            int timeoutSocket = 5000;
            HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
            DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
            HttpPost postRequest = new HttpPost(SERVER_ADDRESS);
            StringEntity input = new StringEntity(str);
            input.setContentType("application/json");
            postRequest.setEntity(input);
            HttpResponse response = httpClient.execute(postRequest);
            result = getResult(response).toString();
            httpClient.getConnectionManager().shutdown();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
}

private StringBuilder getResult(HttpResponse response) throws IllegalStateException, IOException {
            StringBuilder result = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())), 1024);
            String output;
            while ((output = br.readLine()) != null) 
                result.append(output);

            return result;      
}