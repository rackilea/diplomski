import java.util.Scanner;

public class HelloWorld implements Runnable {

    Scanner input = new Scanner(System.in); 

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.run();
        helloWorld.close();
    }

    @Override
    public void run() {
        System.out.println("Type your name: ");
        String name = input.nextLine();
        System.out.printf("%s%s", "Hello World for you, " +
                "".concat(name), "\n");

    }

    public void close() {
        input.close();
    }
}