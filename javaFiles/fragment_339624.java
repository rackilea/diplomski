import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleCalc extends JPanel {
    private static final String[][] BTN_TEXTS = {
        {"C", "Del", "X^2", "+"},
        {"7", "8", "9", "-"},
        {"4", "5", "6", "*"},
        {"1", "2", "3", "/"},
        {"0", ".", "", "="}
    };
    private static final int COLS = 12;
    private static final int GAP = 3;
    private static final char[] NUMBER_ARRAY = "0123456789".toCharArray();
    private static final List<Character> NUMBER_LIST = new ArrayList<>();
    private static final float FONT_SIZE = 36f;
    private JTextField display = new JTextField(COLS);

    static {
        for (char c : NUMBER_ARRAY) {
            NUMBER_LIST.add(c);
        }
    }

    public SimpleCalc() {
        display.setFont(display.getFont().deriveFont(FONT_SIZE));
        display.setFocusable(false);

        int rows = BTN_TEXTS.length;
        int cols = BTN_TEXTS[0].length;
        JPanel buttonPanel = new JPanel(new GridLayout(rows, cols, GAP, GAP));
        for (String[] btnTextRow : BTN_TEXTS) {
            for (String btnText : btnTextRow) {
                if (btnText.isEmpty()) {
                    buttonPanel.add(new JLabel());
                } else {
                    Action action = null;
                    if (NUMBER_LIST.contains(btnText.charAt(0))) {
                        action = new NumericAction(btnText);
                    } else if (".".equals(btnText)) {
                        action = new DotAction(btnText);
                    } else {
                        action = new OperationAction(btnText);
                    }
                    JButton button = new JButton(action);
                    button.setFont(button.getFont().deriveFont(Font.BOLD, FONT_SIZE));
                    buttonPanel.add(button);
                }
            }
        }

        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new BorderLayout(GAP, GAP));
        add(display, BorderLayout.PAGE_START);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private class NumericAction extends AbstractAction {
        public NumericAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = display.getText();
            text += e.getActionCommand();
            display.setText(text);
        }
    }

    private class DotAction extends AbstractAction {
        public DotAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = display.getText();
            if (text.contains(".")) {
                return; // only one dot allowed
            }
            text += e.getActionCommand();
            display.setText(text);
        }
    }

    private class OperationAction extends AbstractAction {
        public OperationAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO write code for operations buttons
        }
    }

    private static void createAndShowGui() {
        SimpleCalc mainPanel = new SimpleCalc();

        JFrame frame = new JFrame("SimpleCalc");
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