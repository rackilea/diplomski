Thread thread = new Thread(new Runnable(){
    @Override
    public void run() {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://myserver.com/form/feedback-mailer.php");
                try {
                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);

                    nameValuePairs.add(new BasicNameValuePair("name", "ab"));
                    nameValuePairs.add(new BasicNameValuePair("email", "abc@abc.com"));
                    nameValuePairs.add(new BasicNameValuePair("message", "abcd"));
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    httpclient.execute(httppost);

                } catch (ClientProtocolException e) {
                        // TODO Auto-generated catch block
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});

thread.start();