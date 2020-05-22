private void login(){
try {
       DefaultHttpClient httpclient = new DefaultHttpClient();
       HttpPost httppost = new HttpPost(url);
       if(postData != null){
            httppost.setEntity(postData);
        }

        HttpResponse response = httpclient.execute(httppost);
        try {
            cookies = httpclient.getCookieStore().getCookies();
        } catch (Exception e) {
        }
    } catch (Throwable e) {
     e.printStackTrace();
    }
}