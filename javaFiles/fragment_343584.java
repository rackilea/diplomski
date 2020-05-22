public static void main(String a[]) throws ClientProtocolException, IOException{
    HttpClient httpClient = new DefaultHttpClient();
    HttpHost proxy=new HttpHost("hostname", portnumber, "scheme"); // ex: hostname="your org proxy host" portnumber=8080 scheme="http"
    httpClient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY,proxy );

    HttpGet getRequest = new HttpGet(
        "https://www.yahoo.com/news/rss/");

    //getRequest.addHeader("accept", "application/xml");
    final RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
    getRequest.setConfig(config);


    HttpResponse response = httpClient.execute(getRequest);

    /*if (response.getStatusLine().getStatusCode() != 200) {
        throw new RuntimeException("Failed : HTTP error code : "
           + response.getStatusLine().getStatusCode());
    }*/

    BufferedReader br = new BufferedReader(
                     new InputStreamReader((response.getEntity().getContent())));

    String output;
    System.out.println("Output from Server .... \n");
    while ((output = br.readLine()) != null) {
        System.out.println(output);
    }

    httpClient.getConnectionManager().shutdown();