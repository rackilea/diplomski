final InputStream in = MyClass.class.getResourceAsStream("mails.txt");
final Reader isr = new InputStreamReader(in, "ISO-8859-1"); //or whatever
final BufferedReader br = new BufferedReader(isr);
try {
    // ...
} finally {
    br.close();
}