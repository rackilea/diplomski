import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class SwapStuff {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        SwapMainPanel mainPanel = new SwapMainPanel();
        JFrame frame = new JFrame("SwapStuff");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}

class SwapMainPanel extends JPanel {
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private ButtonPanel buttonPanel = new ButtonPanel(this); // pass the reference
    private WorkPanel workPanel = new WorkPanel();
    private ViewPanel viewPanel = new ViewPanel();

    public SwapMainPanel() {
        cardPanel.add(workPanel, workPanel.getClass().getName());
        cardPanel.add(viewPanel, viewPanel.getClass().getName());

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.PAGE_START);
        add(cardPanel, BorderLayout.CENTER);
    }

    // one possible way to swap "cards"
    public void nextCard() {
        cardLayout.next(cardPanel);
    }
}

class ButtonPanel extends JPanel {
    private SwapMainPanel mainPanel;

    public ButtonPanel(SwapMainPanel mainPanel) {
        this.mainPanel = mainPanel;  // set the reference!
        add(new JButton(new SwapAction("Swap Panels", KeyEvent.VK_S)));
    }

    private class SwapAction extends AbstractAction {
        public SwapAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.nextCard();
        }
    }
}

class WorkPanel extends JPanel {
    public WorkPanel() {
        setBorder(BorderFactory.createTitledBorder("Work Panel"));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 400);
    }
}

class ViewPanel extends JPanel {
    public ViewPanel() {
        setBorder(BorderFactory.createTitledBorder("View Panel"));
        setBackground(Color.RED);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 400);
    }
}