import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TestFrame extends JFrame {

    public TestFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        pack();
        setVisible(true);
    }

    private void init() {
        TestFrame.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(new JLabel("test"));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("cant minimize");
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        TestFrame.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    }
                });
            }
        });
    }

    public static void main(String... strings) {
        new TestFrame();
    }

}