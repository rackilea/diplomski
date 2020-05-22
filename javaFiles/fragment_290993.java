import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class Line2 extends JPanel {
    private static final int BTN_COUNT = 256;
    private static final Dimension BTN_SZ = new Dimension(40, 40);
    private List<JButton> buttonList = new ArrayList<>();
    private JButton actButton;
    private int index = 0;

    public Line2() {
        JPanel buttonPanel = new JPanel(new GridLayout(16, 0));
        for (int i = 0; i < BTN_COUNT; i++) {
            JButton btn = new JButton("" + (i + 1));
            btn.setBorder(BorderFactory.createEmptyBorder());
            btn.setPreferredSize(BTN_SZ);
            buttonPanel.add(btn);
            buttonList.add(btn);
        }
        JButton actionButton = new JButton("Act");
        actionButton.addActionListener(e -> doAction());
        resetColors();
        buttonList.get(0).setBackground(Color.GREEN);

        setLayout(new BorderLayout());
        add(buttonPanel);
        add(actionButton, BorderLayout.PAGE_END);
    }

    public void resetColors() {
        for (int i = 0; i < buttonList.size(); i++) {
            Color color = Color.YELLOW;
            if (i == BTN_COUNT - 1) {
                color = Color.PINK;
            }
            buttonList.get(i).setBackground(color);
        }
    }

    private void doAction() {
        int timerDelay = 100;
        index = 0;
        new Timer(timerDelay, e -> {
            resetColors();
            if (index == BTN_COUNT) {
                ((Timer) e.getSource()).stop();
            } else {
                // buttonList.get(index).doClick();
                buttonList.get(index).setBackground(Color.GREEN);
                index++;
            }
        }).start(); 
    }

    private static void createAndShowGui() {
        Line2 mainPanel = new Line2();

        JFrame frame = new JFrame("Line 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}