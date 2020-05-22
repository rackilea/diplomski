public class MainClass {

    public static void main(String[] args) {
        try {
            handleGracefully();
        }   catch (FooException e)  {
            System.out.println("World is not that cool");
        }
    }

    public static void handleGracefully() throws FooException {
        try {
            hello();
        } catch (BarException be) {
            System.out.println("Hello world");
        }
    }

    public static void hello() throws BarException     {
        throw new BarException("NYAAH");
    }
}