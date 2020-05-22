import java.awt.BorderLayout;
import javax.swing.*;

public class BetterMain extends JPanel {
    private static final String[] ITEMS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private static final int ROWS = 25;
    private static final int COLUMNS = 40;
    private JButton button = new JButton("Button");
    private JTextField textField = new JTextField(COLUMNS / 2);
    private JComboBox<String> myCombo = new JComboBox<>(ITEMS);
    private JTextArea textArea = new JTextArea(ROWS, COLUMNS);    

    public BetterMain() {
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("This is a JLabel"));
        topPanel.add(myCombo);
        topPanel.add(textField);
        topPanel.add(button);

        JScrollPane scrollPane = new JScrollPane(textArea);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(topPanel, BorderLayout.PAGE_START);
    }

    private static void createAndShowGui() {
        BetterMain mainPanel = new BetterMain();

        JFrame frame = new JFrame("BetterMain");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
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