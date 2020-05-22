@RunWith(MockitoJUnitRunner.class)
    public class DbNameContextHolderTest {

    @Test
    public void setsAndGetsDBNameCorrectly(){
        DbNameContextHolder.setDbName("someName");
        String returnedName = DbNameContextHolder.getDbName();
        assertEquals("someName",returnedName);
    }

    @Test
    public void clearsDBName(){
        DbNameContextHolder.setDbName("someName");
        String returnedName = DbNameContextHolder.getDbName();
        assertEquals("someName",returnedName);
        DbNameContextHolder.clearDbName();
        returnedName = DbNameContextHolder.getDbName();
        assertNull(returnedName);
    }
}