import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InnerClasses {

    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label;

    public InnerClasses() {
        label = new JLabel();
        label.setText("I m label");
        button = new JButton();
        button.setText("Click me ");
        button.addActionListener(new MyActioListener());
        panel = new JPanel();
        panel.add(label);
        panel.add(button);
        frame = new JFrame("Inner class");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    class MyActioListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            label.setText("i have been changed");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                InnerClasses innerClasses = new InnerClasses();
            }
        });
    }
}