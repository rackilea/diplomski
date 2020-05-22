import java.awt.*;
import javax.swing.*;

public class MinSizeForContainer {

    private JFrame frame = new JFrame("some frame title");

    public MinSizeForContainer() {
        JTextArea textArea = new JTextArea(15, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);

        CustomJPanel fatherPanel = new CustomJPanel();
        fatherPanel.setLayout(new SpringLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(fatherPanel, BorderLayout.CENTER);
        frame.setLocation(20, 20);
        frame.setMinimumSize(fatherPanel.getMinimumSize());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MinSizeForContainer Mpgp = new MinSizeForContainer();
            }
        });
    }
}

class CustomJPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(400, 400);
    }
}