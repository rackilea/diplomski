import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JLabel("Waiting"));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                ExampleWorker worker = new ExampleWorker();
                worker.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if ("state".equals(evt.getPropertyName())) {
                            ExampleWorker worker = (ExampleWorker) evt.getSource();
                            switch (worker.getState()) {
                                case DONE: {
                                    try {
                                        System.out.println("PropertyChange: " + worker.get());
                                    } catch (InterruptedException | ExecutionException ex) {
                                        ex.printStackTrace();
                                    }
                                    frame.dispose();
                                }
                                break;
                            }
                        }
                    }
                });
                worker.execute();
            }
        });
    }

    public static class ExampleWorker extends SwingWorker<Integer, Integer> {

        private int n = 0;
        private long startTime;

        @Override
        protected Integer doInBackground() throws Exception {
            System.out.println("doInBackground()");
            startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 3000) {
                n++;
                Thread.yield();
            }
            return n;
        }

        @Override
        protected void process(List<Integer> chunks) {
            for (int value : chunks) {
                System.out.println(value);
            }
        }

        @Override
        protected void done() {
            try {
                System.out.println("Done: " + get());
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        }

    }

}