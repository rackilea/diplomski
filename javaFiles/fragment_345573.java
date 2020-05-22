public class Client {

    private String server;

    public Client(String server) {
        this.server = server;
    }

    private String getBase() {
        return server;
    }

    public String getBaseURI(String str) {
        String result = "";
        try {
            HttpParams httpParameters = new BasicHttpParams();
            int timeoutConnection = 3000;
            HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
            int timeoutSocket = 5000;
            HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
            DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
            HttpGet getRequest = new HttpGet(getBase() + str);
            getRequest.addHeader("accept", "application/json");
            HttpResponse response = httpClient.execute(getRequest);
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
}