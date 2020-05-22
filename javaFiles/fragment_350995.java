import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** @see http://stackoverflow.com/questions/2141325 */
public class MyPanel extends JPanel {

    private static final Random RND = new Random();
    private static final WindowAdapter listener = new WindowAdapter() {

        @Override
        public void windowClosed(WindowEvent e) {
            print(e);
        }

        @Override
        public void windowClosing(WindowEvent e) {
            print(e);
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            print(e);
        }

        private void print(WindowEvent e) {
            System.out.println(e.getWindow().getName() + ":" + e);
        }
    };

    public MyPanel() {
        this.setBackground(new Color(RND.nextInt()));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(320, 240);
    }

    private static void create() {
        for (int i = 0; i < 2; i++) {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setTitle(String.valueOf(i));
            f.add(new MyPanel());
            f.addWindowListener(listener);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                create();
            }
        });
    }
}