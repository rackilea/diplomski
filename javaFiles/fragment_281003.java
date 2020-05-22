import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class AddRowA extends JPanel {
    private static final int PREF_W = 650;
    private static final int PREF_H = 400;

    // JPanel to hold all rows. uses gridlayout that has 1 column and variable number
    // of rows
    private JPanel rowHolderPanel = new JPanel(new GridLayout(0, 1, 1, 1));

    public AddRowA() {
        // outerPanel is a wrapper or container JPanel that is 
        // held by JScrollPane's viewport that holds the rowHolderPanel in 
        // a BorderLayout.PAGE_START location, so the rows don't expand unnecessarily
        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.add(rowHolderPanel, BorderLayout.PAGE_START);
        JScrollPane scrollPane = new JScrollPane(outerPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel addPanel = new JPanel();
        addPanel.add(new JButton(new AddAction("Add")));

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(addPanel, BorderLayout.PAGE_END);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class AddAction extends AbstractAction {
        public AddAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JPanel panel = new JPanel();
            panel.add(new JLabel("Foo"));
            panel.add(Box.createHorizontalStrut(25));
            panel.add(new JButton("Bar"));
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

            rowHolderPanel.add(panel);
            rowHolderPanel.revalidate();
            rowHolderPanel.repaint();
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Add Row A");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new AddRowA());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}