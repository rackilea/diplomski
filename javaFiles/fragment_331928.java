try {
   HttpURLConnection.setFollowRedirects(false);
   HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
   con.setRequestMethod("HEAD");

   con.setConnectTimeout(5000); //set timeout to 5 seconds

   return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
} catch (java.net.SocketTimeoutException e) {
   return false;
} catch (java.io.IOException e) {
   return false;
}