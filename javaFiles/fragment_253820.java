public static final String DB_HOST = "db.host";
   public static final String DB_USER = "db.user";
   public static final String DB_PWD = "db.pwd";

   public static String getDbHost(Properties props)
   {
      return props.getProperty(DB_HOST, "localhost");
   }
   public static String getDbUser(Properties props)
   {
      return props.getProperty(DB_USER, "admin");
   }
   public static String getDbPwd(Properties props)
   {
      return props.getProperty(DB_PWD);
   }