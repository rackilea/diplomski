package stackOverFlow;

import java.awt.BorderLayout;

public class Frame implements Runnable {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Frame());
    }

    @Override
    public void run() {
        JTextArea map;
        JButton btn;
        JLabel lbl;
        map = new JTextArea(10, 50);
        final JScrollPane scrollPanel = new JScrollPane(map);
        btn = new JButton("hello");
        lbl = new JLabel("Text Area: ");
        final JPanel actionPanel = new JPanel(
                new FlowLayout(FlowLayout.LEADING));
        actionPanel.add(lbl);
        actionPanel.add(scrollPanel);
        final JFrame frame = new JFrame("jarvis");
        frame.setLayout(new BorderLayout());
        frame.add(actionPanel, BorderLayout.CENTER);
        frame.add(btn, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}