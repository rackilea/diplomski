URL myURL = new URL("http://example.com/my/path");
URLConnection conn = myURL.openConnection();
conn.setDoOutput(false);
conn.setDoInput(true);

InputStream is = conn.getInputStream();
// read stuff here