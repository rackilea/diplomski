public interface MyInterface {
    void invokeMyMethod();
}

public class MyFirstClass implements MyInterface {
    public void invokeMyMethod() {myFirstMethod();}
    /*...*/
}
public class MySecondClass implements MyInterface {
    public void invokeMyMethod() {mySecondMethod();}
    /*...*/
}

//In some other class...

private void myMethod(List<MyInterface> list) {
    for(MyInterface o : list) {
        o.invokeMyMethod();
    }
}