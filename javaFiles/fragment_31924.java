public class ZonesTest
{
    private static OracleConnectionPoolDataSource ds;

    @BeforeClass
    public static void setUpClass() throws Exception
    {
        try
        {
            // Construct DataSource
            ds = new OracleConnectionPoolDataSource();
            ds.setURL("jdbc:oracle:thin:@192.168.1.104:1521:oracle");
            ds.setUser("admin");
            ds.setPassword("qwerty");
        }
        catch (NamingException ex)
        {
            //Logger.getLogger(MyDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testCountDBRowNum() throws Exception
    {

        Zones instance = new Zones();
        instance.setDs(ds);
        int rows = instance.countDBRowNum();

        System.out.println(rows);

    }
}