class jo extends Thread {
    private int number;

    jo(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Odd numbers are:");
        for (int i = 0; i <= number; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}

class yo extends Thread {

    private int number;

    yo(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Even Numbers are");
        for (int i = 0; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

}
import java.util.Scanner;

class Star {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Enter No. upto which eve-od should be printed");
        Scanner var = new Scanner(System.in);
        int vary = var.nextInt();
        jo money = new jo(vary);
        yo honey = new yo(vary);

        money.start();
        Thread.sleep(5000);
        honey.start();

    }

}