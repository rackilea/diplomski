public static void changeProperty(String filename, String key, String value) throws IOException {
   Properties prop =new Properties();
   prop.load(new FileInputStream(filename));
   prop.setProperty(key, value);
   prop.store(new FileOutputStream(filename),null);
}