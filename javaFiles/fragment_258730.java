public class Example<T extends Throwable> {

    public static void main(String[] args) throws Exception {
        Method m = Example.class.getMethod("method");
        System.out.println(m.getGenericExceptionTypes()[0]);
        System.out.println(m.getExceptionTypes()[0]);
    }

    public void method() throws T {}
}