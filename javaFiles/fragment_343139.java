package test;

public class Test2 {

    public static void main(String[] args) {
        MyService m = getService(MyService.class);
        //m.someMethod(...);
    }

    public static <T extends ServiceInterface> T getService(Class<T> aServiceClass) {
        return null; //??
    }

    //class MyService
    public class MyService extends ServiceInterface{

        //someMethods...

    }

    //class ServiceInterface
    public class ServiceInterface {

        public <T extends ServiceInterface> T getService(Class<T> aServiceClass) {
            return null; //whatever the method is doing
        }

    }
}