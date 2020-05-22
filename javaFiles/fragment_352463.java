import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

/**
 * @see http://stackoverflow.com/a/16837816/230513
 */
public class Test {

    private JFrame f = new JFrame("Test");

    private void display() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new AppInitProgressDialog().getView());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    class AppInitProgressDialog {

        private static final int VIEW_PADDING_VAL = 5;
        private JPanel view;   // Dialog view
        private JPanel panel;
        private JPanel progressPanel;
        private JLabel title;
        private JLabel progressDesc;
        private JProgressBar progressBar;

        private void initPanel(int w, int h) {
            view = new JPanel();
            view.setBorder(BorderFactory.createRaisedBevelBorder());
            view.setBackground(Color.LIGHT_GRAY);
            view.setSize(w, h);
            view.setLayout(new BorderLayout());

            panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createLineBorder(Color.blue));
            panel.setOpaque(false);

            view.add(panel, BorderLayout.CENTER);
        }

        private void initTitle() {
            title = new JLabel("Progress title");
            title.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            panel.add(title, BorderLayout.NORTH);
        }

        private void initProgress() {
            progressPanel = new JPanel(new BorderLayout());
            progressPanel.setBackground(Color.LIGHT_GRAY);
            progressPanel.setBorder(new EmptyBorder(15, 30, 15, 30));
            progressPanel.setBackground(Color.RED);

            progressBar = new JProgressBar(0, 10000);
            progressBar.setStringPainted(true);
            progressBar.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            progressPanel.add(progressBar);

            panel.add(progressPanel);
            progressDesc = new JLabel("Progress description");
            panel.add(progressDesc, BorderLayout.SOUTH);
        }

        public AppInitProgressDialog() {
            initPanel(400, 100);
            initTitle();
            initProgress();
        }

        public JComponent getView() {
            return view;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}