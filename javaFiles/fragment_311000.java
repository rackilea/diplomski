public class Foo {
    public static void main(String[] args) {
        Throwable t = new Throwable();
        for (StackTraceElement e : t.getStackTrace()) {
            System.out.println(e);
        }
        System.out.println("This is the end of main()");
    }
}