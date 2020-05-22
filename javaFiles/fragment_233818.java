import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestProgress {

    public static void main(String[] args) {
        new TestProgress();
    }

    public TestProgress() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JDesktopPane dp = new JDesktopPane() {

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(400, 400);
                    }

                };
                JInternalFrame inf = new JInternalFrame("Progressing", true, false, false, false);
                inf.add(new TestPane());
                inf.pack();
                dp.add(inf);
                inf.setVisible(true);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(dp);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JProgressBar pb;

        public TestPane() {
            setLayout(new GridBagLayout());
            pb = new JProgressBar();
            add(pb);

            LongRunningProcessWorker worker = new LongRunningProcessWorker();
            worker.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    String name = evt.getPropertyName();
                    SwingWorker worker = (SwingWorker) evt.getSource();
                    switch (name) {
                        case "progress":
                            System.out.println(worker.getProgress());
                            pb.setValue(worker.getProgress());
                            break;
                        case "state":
                            switch (worker.getState()) {
                                case DONE:
                                    // Close the window or something
                                    break;
                            }
                            break;
                    }
                }
            });
            worker.execute();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class LongRunningProcessWorker extends SwingWorker {

        @Override
        protected Object doInBackground() throws Exception {

            Random rnd = new Random();
            int outterMax = rnd.nextInt(150) + 50;
            int innerMax = rnd.nextInt(150) + 50;

            System.out.println(outterMax + "/" + innerMax);

            for (int outter = 0; outter < outterMax; outter++) {
                for (int inner = 0; inner < innerMax; inner++) {
                    float progress = (float)((outter * innerMax) + inner) / (float)(innerMax + outterMax);
                    Thread.sleep(10); // Simulate some processing
                }
            }
            return null;
        }

    }

}