private void sendData(ProfileVO pvo) {

    Log.i(getClass().getSimpleName(), "send  task - start");

    HttpParams p=new BasicHttpParams();
    p.setParameter("name", pvo.getName());

    //Instantiate an HttpClient
    HttpClient client = new DefaultHttpClient(p);

    //Instantiate a GET HTTP method
    try {
        HttpResponse response=client.execute(new HttpGet("http://www.itortv.com/android/sendName.php"));
        InputStream is=response.getEntity().getContent();
        //You can convert inputstream to a string with: http://senior.ceng.metu.edu.tr/2009/praeda/2009/01/11/a-simple-restful-client-at-android/
    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    Log.i(getClass().getSimpleName(), "send  task - end");
}