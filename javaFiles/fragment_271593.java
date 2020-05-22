import javax.swing.*;
import java.awt.*;
class JpanelSplit {
    JFrame frame;
    JPanel contentPane;
    JPanel pinkPanel;
    JPanel yellowPanel;
    JPanel bluePanel;
    JPanel twoPanelContainer;

    public JpanelSplit() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel(new GridLayout(2,1));
        pinkPanel = new JPanel();
        pinkPanel.setBackground(Color.PINK);

        yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);    

        bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);

        twoPanelContainer = new JPanel(new GridLayout(1,2));
        twoPanelContainer.add(yellowPanel);
        twoPanelContainer.add(bluePanel);

        contentPane.add(pinkPanel);
        contentPane.add(twoPanelContainer);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new JpanelSplit();
    }
}