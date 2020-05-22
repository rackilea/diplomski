HttpClient httpclient = new DefaultHttpClient();
HttpGet httpget = new HttpGet("http://localhost/users/Robert.WHATEVER");
HttpResponse response = httpclient.execute(httpget);
if (response.getStatusLine().getStatusCode() == 404) {
   System.out.println("User Robert.WHATEVER not found");
}