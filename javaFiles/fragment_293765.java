public class MyObject {

    private static MyObject instance;

    public static MyObject getInstance(..) {
        if (instance != null) {
            return instance;
        }
        return instance = new MyObject(..);
    }

    // private constructor to avoid new instances 
    private MyObject(..) { .. }
}

MyObject anObject = MyObject.getInstance(..); // always returns the same instance