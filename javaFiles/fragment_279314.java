public class MyClass {

    private DoSomethingProvider doSomethingProvider;

    private DbConnector dbConnector;

    public MyClass (DoSomethingProvider p, DbConnector c) {
        doSomethingProvicer = p;
        dbConnector = c;
    }


    protected String createDummyRequest(Holder myHolder){
        //...
        doSomethingProvider.doSomethingParent();
        //...
        dbConnector.callingDB();
        return "processedOutput";
    }
}