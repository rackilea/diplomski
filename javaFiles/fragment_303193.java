Properties props = new Properties();
FileInputStream in = new FileInputStream("C:\\someprops.properties");
try {
  props.load(in);
} finally {
  in.close();
}