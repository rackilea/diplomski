public abstract class AbsModule{
    public void abstract doSomething();
}

public class Module1 implements AbsModule{
    public void doSomething(){
        doSomethingForModule1();
    }
    private void doSomethingForModule1(){
        Your code here
    }
}

public class Module2 implements AbsModule{
    public void doSomething(){
        doSomethingForModule2();
    }
    private void doSomethingForModule2(){
        Your code here
    }
}