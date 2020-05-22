public class HelloWorld {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World from Go! But you cant see me :)");
        while (true) {
            System.out.println("you cant see this because I am outing to the STDOUT of a subshell!");
            Thread.sleep(5000);
        }
    }
}