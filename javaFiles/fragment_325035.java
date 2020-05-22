try {

  URL primaryURL = new URL(web_service_endpoint);
  HttpURLConnection con = (HttpURLConnection) primaryURL.openConnection();
  con.setConnectTimeout(5000); //set timeout to 5 seconds

  //Try retrieving some XML

} catch (java.net.SocketTimeoutException e) {
  //Try connecting to secondary web service
  //Maybe a recursive method call with a different URL or something
}