public class A
{
    private SomeNativeClass someNativeObject;

    public synchronized boolean doSomething(int a){
        return someNativeObject.funcA();
    }
    public synchronized  boolean doSomethingElse(int b){
        return someNativeObject.funcD() && someNativeObject.funcC();
    }
}