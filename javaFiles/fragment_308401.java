import javax.swing.*;
import java.awt.*;

class MainGui {
    JFrame frame = new JFrame();
    JPanel mainPanel = new JPanel();
    JButton newBut = new JButton("New Game");
    JButton continueBut = new JButton("Continue");
    JButton exitBut = new JButton("Exit");
    JLabel backImage = new JLabel(new ImageIcon(
            getClass().getResource("images.jpg")));

    public MainGui() {
        backImage.setLayout(new BorderLayout());
        frame.setContentPane(backImage);
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(newBut, gbc);

        gbc.gridy = 1;
        mainPanel.add(continueBut, gbc);

        gbc.gridy = 2;
        mainPanel.add(exitBut, gbc);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.setSize(250, 275);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                MainGui mainGui = new MainGui();
            }
        });
    }
}