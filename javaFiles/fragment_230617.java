import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnonymousListenerDemo {

    private static final long serialVersionUID = 1L;
    private JFrame frame = new JFrame("AnonymousListenerDemo");
    // Create four buttons
    private JButton jbtNew = new JButton("New");
    private JButton jbtOpen = new JButton("Open");
    private JButton jbtSave = new JButton("Save");
    private JButton jbtPrint = new JButton("Print");

    public AnonymousListenerDemo() {
        JPanel panel = new JPanel();// Create a panel to hold buttons
        panel.add(jbtNew);
        panel.add(jbtOpen);
        panel.add(jbtSave);
        panel.add(jbtPrint);
        // Create and register anonymous inner-class listener
        jbtNew.addActionListener(new ButtonListener());
        frame.add(panel);
        //frame.setTitle("AnonymousListenerDemo");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtNew) {
                System.out.println("Process New");
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AnonymousListenerDemo();
            }
        });
    }
}