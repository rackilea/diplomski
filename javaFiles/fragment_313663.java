public class Test {

    static {
         System.out.println("static initializer");
    }

    {
         System.out.println("instance initializer");
    }

    public Test() {
         System.out.println("constructor");
    }

}