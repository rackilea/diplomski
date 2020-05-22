public class MyBatisSqlSessionFactory {
    public static Map<String,String> properties = new HashMap<String,String>();

    protected static final SqlSessionFactory FACTORY;

    public MyBatisSqlSessionFactory(String userid, String password) {
        try {
            Properties props = new Properties();

            props.setProperty("username", userid);
            props.setProperty("password", password);

            Reader reader = Resources.getResourceAsReader
               ("wsnscc/mybatis/xml/Configuration.xml");

        } catch (Exception e){
            throw new RuntimeException("Fatal Error.  Cause: " + e, e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory
            (String userid, String password) 
            throws RuntimeException {
        if (FACTORY == null) 
            FACTORY = new MyBatisSqlSessionFactory(userid, password);
        return FACTORY;
    }
}