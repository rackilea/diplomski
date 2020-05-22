import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Label;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class IsThereEDT {

    private ScheduledExecutorService scheduler;
    private AccurateScheduledRunnable periodic;
    private ScheduledFuture<?> periodicMonitor;
    private int taskPeriod = 30;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private Date dateRun;
    private JFrame frame1 = new JFrame("Frame 1");
    private Frame frame2 = new Frame("Frame 2");
    private PopupMenu popup1 = new PopupMenu();

    public IsThereEDT() {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        periodic = new AccurateScheduledRunnable() {

            private final int ALLOWED_TARDINESS = 200;
            private int countRun = 0;
            private int countCalled = 0;
            private int maxCalled = 10;

            @Override
            public void run() {
                countCalled++;
                if (countCalled < maxCalled) {
                    if (countCalled % 3 == 0) {
                        /*if (EventQueue.isDispatchThread()) {
                        SwingUtilities.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                        //some stuff
                        }
                        });
                        } else {
                        try {
                        SwingUtilities.invokeAndWait(new Runnable() {

                        @Override
                        public void run() {
                        //some stuff
                        }
                        });
                        } catch (InterruptedException ex) {
                        Logger.getLogger(IsThereEDT.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InvocationTargetException ex) {
                        Logger.getLogger(IsThereEDT.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }*/
                        /*SwingUtilities.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                        System.out.println("Push a new event to EDT");
                        frame1.repaint();
                        isThereReallyEDT();
                        }
                        });*/
                    } else {
                        if (this.getExecutionTime() < ALLOWED_TARDINESS) {
                            countRun++;
                            isThereReallyEDT(); // non on EDT
                        }
                    }
                } else {
                    System.out.println("Terminating this madness");
                    System.exit(0);
                }
            }
        };
        periodicMonitor = scheduler.scheduleAtFixedRate(periodic, 0, taskPeriod, TimeUnit.SECONDS);
        periodic.setThreadMonitor(periodicMonitor);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                isThereReallyEDT();
                Label label1 = new Label("Hello in frame 1");

                for (int i = 1; i <= 5; i++) {
                    MenuItem menuItem = new MenuItem("item" + i);
                    popup1.add(menuItem);
                }
                label1.add(popup1);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.add(label1);
                frame1.pack();
                frame1.setLocation(100, 100);
                frame1.setVisible(true);
            }
        });
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(IsThereEDT.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                //frame2.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
                JLabel label2 = new JLabel("Hello in frame 2");
                frame2.add(label2);
                frame2.pack();
                frame2.setLocation(200, 200);
                frame2.setVisible(true);
                isThereReallyEDT();
            }
        });
    }

    private void isThereReallyEDT() {
        dateRun = new java.util.Date();
        System.out.println("                         Time at : " + sdf.format(dateRun));
        if (EventQueue.isDispatchThread()) {
            System.out.println("EventQueue.isDispatchThread");
        } else {
            System.out.println("There isn't Live EventQueue.isDispatchThread, why any reason for that ");
        }
        if (SwingUtilities.isEventDispatchThread()) {
            System.out.println("SwingUtilities.isEventDispatchThread");
        } else {
            System.out.println("There isn't Live SwingUtilities.isEventDispatchThread, why any reason for that ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IsThereEDT isdt = new IsThereEDT();
    }
}

abstract class AccurateScheduledRunnable implements Runnable {

    private ScheduledFuture<?> thisThreadsMonitor;

    public void setThreadMonitor(ScheduledFuture<?> monitor) {
        this.thisThreadsMonitor = monitor;
    }

    protected long getExecutionTime() {
        long delay = -1 * thisThreadsMonitor.getDelay(TimeUnit.MILLISECONDS);
        return delay;
    }
}