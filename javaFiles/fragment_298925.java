public class FirstClass implements MyInterface {
    public void method() {
        NetworkCallClass clazz = new NetworkCallClass(this);
        clazz.specificRequest();
    }

    @Override
    public void onDesiredLoadedData() {
        // here you are your callback
    }
}

public class NetworkCallClass {
    MyInterface _callbacks;

    public NetworkCallClass(MyInterface callbacks) {
        _callbacks = callbacks;
    }

    public void specificRequest() {
        // code
        if (networkResponse == 200) {
            _callbacks.onDesiredLoadedData();
        }
    }
}