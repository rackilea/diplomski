import java.awt.*;
import javax.swing.*;

public class LabelNotVisible {
    public static void main(String[] arguments) {
        SwingUtilities.invokeLater(() -> new LabelNotVisible().createAndShowGui());
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame("Stack Overflow");
        frame.setBounds(100, 100, 800, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jp = new JPanel();
        jp.setBackground(Color.decode("#ffffff"));
        //jp.setBounds(0, 35, 400, 315);

        JPanel mostInner = new JPanel();
        mostInner.setForeground(Color.black);
        //mostInner.setBounds(207, 5, 190, 240);
        jp.add(mostInner);

        JLabel jltxt = new JLabel();
        jltxt.setText("Test");

        mostInner.add(jltxt);

        frame.getContentPane().add(jp);
        frame.setVisible(true);
    }
}