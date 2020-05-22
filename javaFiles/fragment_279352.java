import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MyUserInterface extends JPanel {
    public static final String MAIN = "main";
    public static final String HELP = "help";
    private MainPanel mainPanel = new MainPanel(this);
    private HelpPanel helpPanel = new HelpPanel();

    private CardLayout cardLayout = new CardLayout();

    public MyUserInterface() {
        setLayout(cardLayout);
        add(mainPanel, MAIN);
        add(helpPanel, HELP);

    }

    public void showview(String key) {
        cardLayout.show(this, key);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("MyUserInterface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyUserInterface());
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

class HelpPanel extends JPanel {
    public HelpPanel() {
        add(new JLabel("Help", SwingConstants.CENTER));
        setBorder(BorderFactory.createTitledBorder("Help Panel"));
    }
}

class MainPanel extends JPanel {
    private static final Color BG = Color.CYAN;
    private static final int PREF_W = 800;
    private static final int PREF_H = 600;
    private MyUserInterface myUserInterface;

    public MainPanel(MyUserInterface myUserInterface) {
        setBackground(BG);
        setBorder(BorderFactory.createTitledBorder("Main Panel"));
        this.myUserInterface = myUserInterface;
        add(new JButton(new HelpAction("Help")));
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class HelpAction extends AbstractAction {
        public HelpAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            myUserInterface.showview(MyUserInterface.HELP);
        }
    }
}