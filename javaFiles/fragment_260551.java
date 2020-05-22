import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Scanny {

    public static void main(String[] args) {
        new Scanny();
    }

    public Scanny() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                try {
                    BufferedImage empty = ImageIO.read(...);
                    BufferedImage good = ImageIO.read(...);
                    BufferedImage bad = ImageIO.read(...);

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new ScannerPane(new ImageIcon(empty), new ImageIcon(good), new ImageIcon(bad)));
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public class ScannerPane extends JPanel {

        private JLabel label;
        private Icon empty;
        private Icon good;
        private Icon bad;

        public ScannerPane(Icon empty, Icon good, Icon bad) {
            setLayout(new BorderLayout());
            this.empty = empty;
            this.good = good;
            this.bad = bad;

            label = new JLabel(empty, JLabel.CENTER);
            add(label);

            ScannerWorker worker = new ScannerWorker(new ScannerObserver() {
                @Override
                public void scanWasGood() {
                    label.setIcon(good);
                }

                @Override
                public void scanWasBad() {
                    label.setIcon(bad);
                }
            });
            worker.execute();
        }

    }

    public interface ScannerObserver {
        public void scanWasGood();
        public void scanWasBad();
    }

    public class ScannerWorker extends SwingWorker<Void, Boolean> {

        private ScannerObserver observer;

        public ScannerWorker(ScannerObserver observer) {
            this.observer = observer;
        }

        @Override
        protected Void doInBackground() throws Exception {
            Scanner in = new Scanner(System.in);

            while (true) {
                String scan1 = in.nextLine();
                String scan2 = in.nextLine();

                String injectorExtract = scan2.substring(19);

                if (scan1.compareTo(injectorExtract) != 0) {
                    publish(Boolean.TRUE);
                } else {
                    publish(Boolean.FALSE);
                }
            }
        }

        @Override
        protected void process(List<Boolean> chunks) {
            boolean last = chunks.get(chunks.size() - 1);
            if (last) {
                observer.scanWasGood();
            } else {
                observer.scanWasBad();
            }
        }

    }

}