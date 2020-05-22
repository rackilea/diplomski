public class DataCore {

    // Singletons Tests - static
    static DCTest test;

    //Called when the DataCore class is loaded.
    static{
        test = DCTest.getInstance();
        test.setInt(0);
    }
}