public class A{
    private static volatile String sharedVariable;
    private static final Object lockObject = new Object();

    private void updateVariable(String newValue){
        //... some code
        synchronized(lockObject){
            //... code to check whether to update the value
            sharedVariable = newValue;
        }
    }