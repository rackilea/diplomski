public static void loadConfiguration()
{
    SQLMap.setMapFile(file);
    DBUtility.initMapClient();  // notify DBUtility
    List list = DBUtility.loadUsers();
}

public class DBUtility
{
    protected static SqlMapClient sqlMap;  // do not initialize too early

    public static void initMapClient()
    {
        sqlMap = SQLMap.getSqlMapInstance();  // wait for SQLMap to be ready
    }