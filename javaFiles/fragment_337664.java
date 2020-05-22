public String request(String fUrl){
    String page = "";
    try
    {
        HttpClient hc = new DefaultHttpClient();
        HttpPost post = new HttpPost(fUrl);
        HttpResponse response = hc.execute(post);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
        {
            page = EntityUtils.toString(response.getEntity());
        }
    } catch(IOException e) {
        e.printStackTrace();
        System.out.println("Exception Thrown");
    }
    return page;
}