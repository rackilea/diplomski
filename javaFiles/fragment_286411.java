import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;

class Alarm {

    private static boolean run = true;

    public static void main(String[] args) {
        long delay;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a delay in seconds: ");
        delay = scan.nextInt()*1000;

        final Timer timer = new Timer();

        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(run) {
                   Toolkit.getDefaultToolkit().beep();
                } else {
                   timer.cancel();
                   timer.purge();
                }
            }
        };

        timer.schedule(task, delay);

        // set run to false here to stop the timer.
        run = false;
    }
}