Writer writer = new StringWriter();
byte[] buffer = new byte[1024];

//Reader reader2 = new BufferedReader(new InputStreamReader(request.getInputStream()));
InputStream reader = request.getInputStream();
int n;
while ((n = reader.read(buffer)) != -1) {
    writer.toString();

}
String retval = writer.toString();
retval = "";