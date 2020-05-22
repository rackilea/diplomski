public class MyHandler implements java.io.Closeable {
    private static MyHandler singleton = new MyHandler();
    private MyHandler() {}
    public static MyHandler getInstance() {
        return singleton;
    }

    @Override
    public void close() {
        //close stuff  
    }
}

try(MyHandler h = MyHandler.getInstance()){ }