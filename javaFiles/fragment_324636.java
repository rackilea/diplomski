Properties prop = new Properties();
InputStream in = MyClass.class.getResourceAsStream("prop.properties");
try {
  prop.load(in);
} finally {
  in.close();
}