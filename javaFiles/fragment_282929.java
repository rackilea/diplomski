try {
    HttpClient client = new DefaultHttpClient();  
    String getURL = "http://server/ilwebservice.asmx/PlaceGPSCords?userid="+uid+"&longitude="+lng1+"&latitude="+lat1+";
    HttpGet get = new HttpGet(getURL);
    HttpResponse responseGet = client.execute(get);  
    HttpEntity resEntityGet = responseGet.getEntity();  
    if (resEntityGet != null) {  
                //do something with the response
                Log.i("GET RESPONSE",EntityUtils.toString(resEntityGet));
            }
} catch (Exception e) {
e.printStackTrace();
}