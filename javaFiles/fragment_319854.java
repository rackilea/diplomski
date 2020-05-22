URL myURL = new URL("http://example.com/my/path");
URLConnection conn = myURL.openConnection();
conn.setDoOutput(true);
conn.setDoInput(true);

OutputStream os = conn.getOutputStream();
os.write("Hi there!");
os.close();

InputStream is = conn.getInputStream();
// read stuff here