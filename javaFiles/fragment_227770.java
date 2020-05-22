public class DatabaseTest extends AndroidTestCase {
    private MyDatabase db;

    public void setUp(){
        RenamingDelegatingContext context 
        = new RenamingDelegatingContext(getContext(), "test_");
        db = new MyDatabase(context);
    }

    public void testAddEntry(){
        // Here I have my new database which is not connected to the standard database of the App
    }

    public void tearDown() throws Exception{
        db.close(); 
        super.tearDown();
    }
}