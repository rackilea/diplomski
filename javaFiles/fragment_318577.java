public void port01 (View view) {

    try{
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet request = new HttpGet();
        URI website = new URI("http://192.168.2.66/index.html?o0=1");
        request.setURI(website);
        HttpResponse response = httpclient.execute(request);

    }catch(Exception e){

    }
}