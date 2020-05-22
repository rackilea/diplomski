public class SingeltonDB {
    private static DBconnImpl db = null;
    private static SingeltonDB singalDb = null;
    private static ConcurrentSkipListSet<String> tableNames = new ConcurrentSkipListSet<String>();

    private SingeltonDB(String username, String password) {
        db = new DBconnImpl();
        db.connect(username, password);
        System.out.println("The database was connected");
    }

    public static boolean isOpen() {
        return (db != null);
    }

    public synchronized static SingeltonDB getInstance(String username,
            String password) throws Exception {
        if (db != null) {
            throw (new Exception("The database is  open"));
        } else {
            System.out.println("The database is now open");
            singalDb = new SingeltonDB(username, password);
        }
        return singalDb;
    }

    public synchronized static SingeltonDB getInstance() throws Exception {
        if (db == null) {
            throw (new Exception("The database is not open"));
        }

        return singalDb;
    }

    private static void checkDbOpened() throws Exception {
        if (db == null) {
            throw new Exception("The database is not open");
        }
    }

    private static void checkForTable(String tableName) {
        if (tableNames.add(tableName)) {
           db.create(tableName);
        }
    }

    public void create(String tableName) throws Exception {
        checkDbOpened();
        checkForTable(tableName);
    }

    public  User query(String tableName, int rowID) throws Exception {
        checkDbOpened();
        checkForTable(tableName);
        return (db.query(tableName, rowID));
    }

    public  void update(String tableName, User user) throws Exception {
        checkDbOpened();
        checkForTable(tableName);
        db.update(tableName, user);
    }

}