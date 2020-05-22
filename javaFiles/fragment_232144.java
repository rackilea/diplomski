public interface MyClassFactory {
    public MyClass Create(string functionName);
}

public class MyClassFactoryImp implements MyClassFactory {
    public MyClass Create(string functionName) {
        MyClass myClass = new MyClass();
        myClass.setFileName(functionName);
        return myClass
    }
}