import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChatBox extends JPanel {
    private static final int COLS = 40;
    private JTextField input = new JTextField(COLS);
    private JTextArea output = new JTextArea(20, COLS);
    private JButton submitButton = new JButton("Submit");

    public ChatBox() {
        output.setFocusable(false); // user can't get into output
        JScrollPane scrollPane = new JScrollPane(output);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ActionListener inputListener = e -> {
            String text = input.getText().trim();
            if (text.isEmpty()) {
                return;
            }
            output.append(text + "\n");

            input.setText("");
            input.requestFocusInWindow();
        };

        input.addActionListener(inputListener);
        submitButton.addActionListener(inputListener);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.add(input);
        bottomPanel.add(submitButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private static void createAndShowGui() {
        ChatBox mainPanel = new ChatBox();

        JFrame frame = new JFrame("Chat Box");
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