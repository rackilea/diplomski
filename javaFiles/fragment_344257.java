import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ButtonColorChange extends JPanel {
    private JButton button = new JButton(new ButtonAction("Press Me"));

    public ButtonColorChange() {
        add(button);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("ButtonColorChange");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ButtonColorChange());
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

class ButtonAction extends AbstractAction {
    private static final Color COLOR_1 = Color.BLUE;
    private static final Color COLOR_2 = Color.RED;

    public ButtonAction(String name) {
        super(name);
        int mnemonic = (int) name.charAt(0);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton btn = (AbstractButton) e.getSource();
        Color c = btn.getBackground();
        c = c == COLOR_1 ? COLOR_2 : COLOR_1;
        btn.setBackground(c);
    }
}