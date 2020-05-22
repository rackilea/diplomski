import java.util.Scanner;
public class TestInput {

    public static void main(String[] aa)
    {
         new Thread(new T1()).start();
         System.out.println("MOVED FURTHER");
    }

    public static class T1 implements Runnable
    {

        public void run() {

            Scanner k2sk;
            k2sk = new Scanner(System.in);
            k2sk.nextLine();
            System.out.println("DONE");
        }
    }
}