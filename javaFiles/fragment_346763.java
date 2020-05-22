URL url;
URLConnection urlConn;
DataOutputStream printout;
DataInputStream  input;
url = new URL (getCodeBase().toString() + "env.tcgi");
urlConn = url.openConnection();
urlConn.setDoInput (true);
urlConn.setDoOutput (true);
urlConn.setUseCaches (false);
urlConn.setRequestProperty("Content-Type","application/json");   
urlConn.setRequestProperty("Host", "android.schoolportal.gr");
urlConn.connect();  
//Create JSONObject here
JSONObject jsonParam = new JSONObject();
jsonParam.put("ID", "25");
jsonParam.put("description", "Real");
jsonParam.put("enable", "true");