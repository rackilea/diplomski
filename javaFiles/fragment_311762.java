public class MyClassLoader extends ClassLoader {
    public MyClassLoader(ClassLoader other) {
         super(other);
         System.out.println("Hi there");
         System.exit(0);
    }
}