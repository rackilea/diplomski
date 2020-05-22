public class Printer extends Thread {

    public Semaphore stopped = new Semaphore(1);
    private int x;

    @Override
    public void run() {
        while (true) {
            try {
                stopped.acquire();
                System.out.println(++x);
                stopped.release();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        printer.start();

        Scanner scan = new Scanner(System.in);
        while(true) {
            String command = scan.nextLine();
            if ("BREAK".equals(command)) {
                printer.stopped.acquire(1);
            } else if ("RESTART".equals(command)) {
                printer.stopped.release(1);
            }
        }
}