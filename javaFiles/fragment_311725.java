public class MyApplication extends Application {

    public MyApplication(@Context Dispatcher dispatcher) {
        MyClass myInstance = new MyClass();
        dispatcher.getDefaultContextObjects().put(MyClass.class, myInstance);
    }

 }