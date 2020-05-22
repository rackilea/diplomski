URL url = new URL("http://machineA/path/to/size.jsp");
InputStream in = url.openStream();
Reader reader = new InputStreamReader(in, "UTF-8");

Properties prop = new Properties();
try {
    prop.load(reader);
} finally {
    reader.close();
}
System.out.println( prop.getProperty("total_vault_size"));