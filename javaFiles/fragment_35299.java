public class DbProps {
  public static final String URL;
  public static final String USER;
  public static final String PASSWORD;

  static {
       try{
         InputStream is = ReadValues.class.getResourceAsStream(PROP_FILE);
         try {
           Properties prop = new Properties();
           prop.load(is);
           URL = prop.getProperty("DB_URL");
           USER = prop.getProperty("DB_USER");
           PASSWORD = prop.getProperty("DB_PWD");
         } finally {
           is.close();
         }
       }catch(Exception e){
         throw new RuntimeException("Failed to read from " + PROP_FILE + " file.", e);
       }
  }
}