public static boolean isUrlReachable(String host) {
  String URLName="http://"+host+":4848";
  boolean isUp = false;
  try {
     HttpURLConnection.setFollowRedirects(false);
     HttpURLConnection con = (HttpURLConnection) new URL(URLName).openConnection();
     con.setRequestMethod("GET");
     isUp = (con.getResponseCode() == HttpURLConnection.HTTP_OK);
     con.disconnect();
  }
  catch (Exception e) {
     return isUp;
  }

  return isUp;