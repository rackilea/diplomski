URL url=new URL("https://unsplash.com/photos/65sru5g6xHk/download");
HttpURLConnection.setFollowRedirects(false);
HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
httpURLConnection.setDoInput(true);
httpURLConnection.connect();
System.out.println(httpURLConnection.getResponseCode());
if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_MOVED_TEMP){
   URL redirectUrl = new URL(httpURLConnection.getHeaderField("Location"));
   System.out.println(redirectUrl);
}
InputStream inptStream=httpURLConnection.getInputStream();