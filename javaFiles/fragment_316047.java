SSLSocket s = (SSLSocket) SSLSocketFactory.getDefault().createSocket("www.google.com", 443);
s.startHandshake();
s.setSoTimeout(60 * 1000);

OutputStream os = s.getOutputStream();
InputStream is = s.getInputStream();

String request = "GET https://www.google.com/ HTTP/1.1\r\n";
os.write(request.getBytes("UTF8"));
os.flush();

String str;
BufferedReader reader = new BufferedReader(new InputStreamReader(is));
while ((str = reader.readLine()) != null) {
    System.out.println(str);
}