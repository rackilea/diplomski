public class http {
   public void myMethodName() {
       HttpClient httpclient = new DefaultHttpClient();
       HttpPost httppost = new HttpPost("http://www.yoursite.com/script.php");

       List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
       nameValuePairs.add(new BasicNameValuePair("id", "12345"));
       nameValuePairs.add(new BasicNameValuePair("stringdata", "AndDev is Cool!"));
       httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

       // Execute HTTP Post Request
       HttpResponse response = httpclient.execute(httppost);
   }
}