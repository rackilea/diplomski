public class Test {
   public static final String DERBY_HOME = "derby.system.home";

   // ***** the two Strings below will be different for you *****
   public static final String DERBY_HOME_PATH = "D:/DerbyDB";
   private static final String DB_NAME = "sample";

   public static void main(String[] args) {
      System.setProperty(DERBY_HOME, DERBY_HOME_PATH);
      Connection conn = null;
      try {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
         conn = DriverManager.getConnection("jdbc:derby:" + DB_NAME);

      } catch (InstantiationException | IllegalAccessException
            | ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      } finally {
         if (conn == null) {
            System.exit(-1);
         }
      }

      // .... etc...