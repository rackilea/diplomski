// not much point on allocating a huge buffer here
char[] buffer = new char[4096];
InputStreamReader reader = new InputStreamReader(responseEntity.getContent());
try {
    StringWriter writer = new StringWriter();
    while (true) {
        int numRead = reader.read(buffer);
        if (numRead < 0) {
           break;
        }
        writer.write(buffer, 0, numRead);
    }
} finally {
    reader.close();
}
stream1.close();
String sInvokeReturnValue = writer.toString();