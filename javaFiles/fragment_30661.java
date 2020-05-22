final String encoding = "UTF-8"; // "UTF16LE" or "UTF-16BE"

byte[] b = ...;
String s = new String(b, encoding);

InputStream is = ...;
BufferedReader reader = new BufferedReader(new InputStreamReader(is, encoding));
for (;;) {
    String line = reader.readLine();
}