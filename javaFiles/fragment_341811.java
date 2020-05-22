String urlStr = "my url";
URL url = new URL(urlStr);
HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
// Get OutputStream
PrintWriter out = new PrintWriter(httpConn.getOutputStream());
// transmitting data
String param = "my parameters";
// This statement is important
out.print(new String(param.getBytes("UTF-8")));