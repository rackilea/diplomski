import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ScrollingText100 {

    public static void main(String[] args) {
        new ScrollingText100();
    }

    public ScrollingText100() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private String text;
        private int index;
        private JTextArea textArea;

        public TestPane() {            
            setLayout(new BorderLayout());
            textArea = new JTextArea(2, 40);
            add(textArea);

            text = "Please login to continue...\n" + "Type 'help' for more information.\n";
            Timer timer = new Timer(50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (index < text.length() - 1 && index >= 0) {
                        String newChar = Character.toString(text.charAt(index));
                        textArea.append(newChar);
                        index++;
                    } else {
                        textArea.setText(null);
                        index = 0;
                        // You could stop the timer here...
                    }
                }
            });
            timer.start();
        }

    }

}