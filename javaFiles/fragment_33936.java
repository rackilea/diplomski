import java.lang.*;

public class PrintWithDelayExample {
    public static void main(String[]args) {
        printWithDelay("Hello! World", 500);
    }

    public static void printWithDelay(String data, long delay) {
        for (char c : data.toCharArray()) {
            try {
                Thread.sleep(delay);
                System.out.print(c);
            } catch (InterruptedException e) {}
        }
        System.out.println();
    }
}