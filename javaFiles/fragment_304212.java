import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private static final long   serialVersionUID    = 1L;

    public static void main(String[] args) {
        new MyFrame();
    }

    public MyFrame() {
        super("My Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints c;
        final Insets insets = new Insets(4, 4, 4, 4);
        final Insets buttonInsets = new Insets(4, 4, 4, 8);

        JLabel dbLocationLabel = new JLabel("Database file:");
        c = new GridBagConstraints();
        c.insets = insets;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(dbLocationLabel, c);

        JTextField dbLocationText = new JTextField();
        c = new GridBagConstraints();
        c.insets = insets;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
//        c.gridwidth = 5;
        c.gridy = 0;
        c.weightx = 0.1;
        mainPanel.add(dbLocationText, c);

        JButton dbLocationButton = new JButton("...");
        c = new GridBagConstraints();
        c.insets = buttonInsets;
        c.gridx = 2;
        c.gridy = 0;
        mainPanel.add(dbLocationButton, c);

        this.add(mainPanel);
        this.setSize(500, 150);
        this.setLocation(300, 400);
        this.setVisible(true);
    }
}