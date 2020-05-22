public class Example {
    public static void main(String[] args) throws Exception {
        Method m = Example.class.getMethod("method");
        System.out.println(m.getGenericExceptionTypes()[0]);
        System.out.println(m.getExceptionTypes()[0]);
    }   
    public static <T extends Throwable> void method() throws T {}
}