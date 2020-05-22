private static String linkCorrector(String link) throws ClientProtocolException, IOException{
        HttpClient client = new DefaultHttpClient();
        HttpParams params = client.getParams();
        HttpClientParams.setRedirecting(params, false);
        HttpGet method = new HttpGet(link);
        HttpResponse resp = client.execute(method);
        String location = null;
        Header h = resp.getLastHeader("Location");
        if(h == null || h.getValue() == null){
            location = "";
        }
        else{
            location = resp.getLastHeader("Location").getValue();
        }
        return location;
    }