public class DataCore {

    // Singletons Tests - nonstatic
    DCTest test;

    public DataCore(){
        test = DCTest.getInstance();
        test.setInt(0);
    }
}