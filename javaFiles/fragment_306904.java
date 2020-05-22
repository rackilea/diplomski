String sConfigFile = "any.properties";

InputStream in = MyClass.class.getClassLoader().getResourceAsStream(sConfigFile);
if (in == null) {
    System.out.println("ugly error handling :D");
}
Properties props = new java.util.Properties();
try {
    props.load(in);
} catch (IOException e) {
    e.printStackTrace();
}