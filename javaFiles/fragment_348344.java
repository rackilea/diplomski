import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestCardLayout {

    PanelOne p1 = new PanelOne();
    PanelTwo p2 = new PanelTwo();
    PanelThree p3 = new PanelThree();

    CardLayout layout = new CardLayout();
    JPanel cardPanel = new JPanel(layout);

    public TestCardLayout() {
        JButton showOne = new JButton("Show One");
        JButton showTwo = new JButton("Show Two");
        JButton showThree = new JButton("Show Trree");
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(showOne);
        buttonsPanel.add(showTwo);
        buttonsPanel.add(showThree);
        showOne.addActionListener(new ButtonListener());
        showTwo.addActionListener(new ButtonListener());
        showThree.addActionListener(new ButtonListener());

        cardPanel.add(p1, "panel 1");
        cardPanel.add(p2, "panel 2");
        cardPanel.add(p3, "panel 3");

        JFrame frame = new JFrame("Test Card");
        frame.add(cardPanel);
        frame.add(buttonsPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if ("Show One".equals(command)) {
                layout.show(cardPanel, "panel 1");
            } else if ("Show Two".equals(command)) {
                layout.show(cardPanel, "panel 2");
            } else {
                layout.show(cardPanel, "panel 3");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestCardLayout testCardLayout = new TestCardLayout();
            }
        });
    }
}

class PanelOne extends JPanel {

    public PanelOne() {
        setBackground(Color.GREEN);
        add(new JLabel("Panel one"));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}

class PanelTwo extends JPanel {

    public PanelTwo() {
        setBackground(Color.BLUE);
        add(new JLabel("Panel two"));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}

class PanelThree extends JPanel {

    public PanelThree() {
        setBackground(Color.YELLOW);
        add(new JLabel("Panel three"));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}