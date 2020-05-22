import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class Start {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Hello!");
                JButton button = new JButton("Click me!");
                JLabel label = new JLabel("woah");
                JTextField textField = new JTextField(12);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel p1 = new JPanel();
                JPanel p2 = new JPanel();

                p1.setLayout(new FlowLayout());

                p1.add(textField);
                p1.add(label);

                p2.add(button);

                frame.add(p1, BorderLayout.NORTH);
                frame.add(p2, BorderLayout.SOUTH);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }
}