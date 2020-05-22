import javax.swing.*;

public class ButtonTest {
    public static void main(String[] args) {
        JButton button1 = new JButton("Some label");
        JButton button2 = new JButton("Some much longer label");
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.add(button1);
        panel.add(button2);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}