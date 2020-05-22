public class DatabaseFactory {

    public static Database create(DatabaseType type, String dbName) throws Exception {
       Database db = null;
       Constructor cons = type.getDatabase().getDeclaredConstructor(new Class[] { String.class });
       cons.setAccessible(true);
       db = cons.newInstance(dbName);

       return db;
    }

}