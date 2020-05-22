import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class App2 extends JPanel {
    private static final int GAP = 5;
    private JTextField textField1 = new JTextField(GAP);
    private JTextField textField2 = new JTextField(GAP);
    private JTextField textField3 = new JTextField(GAP);
    private JTextArea textArea = new JTextArea(15, 30);

    public App2() {
        JPanel topPanel = new JPanel(new GridLayout(1, 0, GAP, GAP));
        topPanel.add(textField1);
        topPanel.add(textField2);
        topPanel.add(textField3);
        topPanel.add(new JButton("Add"));

        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 0, GAP, GAP));
        bottomPanel.add(new JButton("Save"));
        bottomPanel.add(new JButton("Run (F1)"));
        bottomPanel.add(new JLabel(""));
        bottomPanel.add(new JLabel(""));

        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new BorderLayout(GAP, GAP));
        add(topPanel, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Auto Clicker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new App2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}