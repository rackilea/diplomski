import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InvocationEvent;
import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TestEventQueue {

    private final ThreadTrackingEventQueue queue;

    public static class ThreadTrackingEventQueue extends EventQueue {

        private Field notifierField;
        private Hashtable<AWTEvent, Thread> waitingThreads = new Hashtable<AWTEvent, Thread>();

        public ThreadTrackingEventQueue() throws NoSuchFieldException, SecurityException {
            notifierField = InvocationEvent.class.getDeclaredField("notifier");
            notifierField.setAccessible(true);
        }

        @Override
        public void postEvent(AWTEvent event) {
            if (!SwingUtilities.isEventDispatchThread() && event.getClass() == InvocationEvent.class) {
                try {
                    Object object = notifierField.get(event);
                    if (object != null) {
                        // This thread is waiting to be notified: record it
                        waitingThreads.put(event, Thread.currentThread());
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            super.postEvent(event);
        }

        @Override
        protected void dispatchEvent(AWTEvent event) {
            try {
                super.dispatchEvent(event);
            } finally {
                if (event.getClass() == InvocationEvent.class) {

                    waitingThreads.remove(event);
                }
            }

        }

        public Hashtable<AWTEvent, Thread> getWaitingThreads() {
            return waitingThreads;
        }
    }

    public TestEventQueue(ThreadTrackingEventQueue queue) {
        this.queue = queue;
    }

    private void initUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea textArea = new JTextArea(30, 80);
        JButton button = new JButton("Start");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    start();
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        frame.add(new JScrollPane(textArea));
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        Timer t = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Hashtable<AWTEvent, Thread> waitingThreads = (Hashtable<AWTEvent, Thread>) queue.getWaitingThreads().clone();
                if (waitingThreads.size() > 0) {
                    for (Thread t : queue.getWaitingThreads().values()) {
                        textArea.append("Thread " + t.getName() + " is waiting for EDT\n");
                    }
                } else {
                    textArea.append("No threads are waiting\n");
                }
            }
        });
        t.start();
    }

    protected void start() throws InterruptedException {
        final Random random = new Random();
        ExecutorService pool = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {
            pool.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    System.out.println("sleeping before invoke and wait");
                    Thread.sleep(random.nextInt(2000) + 200);
                    System.out.println("invoke and wait");
                    SwingUtilities.invokeAndWait(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                System.out.println("sleeping on EDT, bwark :-(");
                                // Very very bad, but trying to make collisions
                                // happen
                                Thread.sleep(random.nextInt(200) + 100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    return true;
                }
            });
        }
        System.out.println("Invoked all");
    }

    public static void main(String[] args) throws NoSuchFieldException, SecurityException {
        final ThreadTrackingEventQueue queue = new ThreadTrackingEventQueue();
        Toolkit.getDefaultToolkit().getSystemEventQueue().push(queue);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    TestEventQueue test = new TestEventQueue(queue);
                    test.initUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}