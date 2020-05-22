InputStream is = getClass().getResourceAsStream("/x.properties");
Properties p = new Properties();
try {
  p.load(is);
} catch (IOException e) {
  e.printStackTrace();
} finally {
  if (is != null) {
    try {
      is.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}