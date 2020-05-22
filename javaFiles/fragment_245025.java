private void getConnection(String target, String user, String pass) throws Exception  
{  
  URL url = new URL(target);  
  URLConnection conn = url.openConnection();  
  //Here's where basic auth kicks in  
  String creds = user + ":" + pass;  
  String encoded = new sun.misc.BASE64Encoder().encode(creds.getBytes());  
  conn.setRequestProperty("Authorization", "Basic " + encoded);  
  //This part doesn't rely on authentication  
  conn.connect();  
}