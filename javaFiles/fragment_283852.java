import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyPanelTest extends JPanel {
    private TextFieldPanel textFieldPanel = new TextFieldPanel();
    private CardLayout cardLayout = new CardLayout();

    public MyPanelTest() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new ButtonAction("Press Me")));        
        setPreferredSize(new Dimension(400, 200));
        setLayout(cardLayout);
        add(buttonPanel, "button panel");
        add(textFieldPanel, TextFieldPanel.NAME);
    }

    private class ButtonAction extends AbstractAction {

        public ButtonAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(MyPanelTest.this, TextFieldPanel.NAME);
            textFieldPanel.textFieldRequestFocus();
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("My Panel Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyPanelTest());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}