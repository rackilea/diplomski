Thread networkThread = new Thread() {
   public void run() {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://www.website.com/notification.php");
        HttpResponse response = httpclient.execute(httppost);
        String result = EntityUtils.toString(httpresponse.getEntity());

        if("1".equals(result.trim()){
            showNotification(); // You have to implement this
        }
    }
}
networkThread.start();