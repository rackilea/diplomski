class LastPrintedMonitor {
    public boolean wasLastEven = false;

}

class PrinterOdd implements Runnable {

    LastPrintedMonitor monitor;

    public PrinterOdd(LastPrintedMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 2; i < 40; i += 2) {
            synchronized (monitor) {
                while (!monitor.wasLastEven) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(i);
                monitor.wasLastEven = false;
                monitor.notifyAll();
            }
        }

    }

}

class PrinterEven implements Runnable {

    LastPrintedMonitor monitor;

    public PrinterEven(LastPrintedMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 1; i < 40; i += 2) {
            synchronized (monitor) {
                while (monitor.wasLastEven) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(i);
                monitor.wasLastEven = true;
                monitor.notifyAll();
            }
        }

    }

}

public class EvenOddPrinterDemo {

    public static void main(String[] args) {
        LastPrintedMonitor monitor = new LastPrintedMonitor();

        Thread odd = new Thread(new PrinterOdd(monitor));
        Thread even = new Thread(new PrinterEven(monitor));

        odd.start();
        even.start();

        try {
            odd.join();
            even.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done!");

    }

}