import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;

public class MainControl extends JFrame {

    private static final long serialVersionUID = 14L;
    private JPanel configurationPane;
    private JPanel feedbackPane;
    private JTextArea feedback;
    private JTabbedPane plotTabPane;
    private JPanel consolePane;
    private JPanel rightPanel;

    public MainControl() {
        setTitle("test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 860, 660);
        initiateComponents();
    }

    private void initiateComponents() {
        JPanel mainPanel = new JPanel();

        configurationPane = new JPanel();
        configurationPane.setBorder(getTitleBorder("Configuration"));
        configurationPane.setLayout(new MigLayout());

        plotTabPane = new JTabbedPane();
        plotTabPane.add("Tab1", new JPanel());

        consolePane = new JPanel(new MigLayout("", "", ""));
        consolePane.setBorder(getTitleBorder("Console"));

        feedback = new JTextArea();
        feedbackPane = new JPanel();
        feedbackPane.setBorder(getTitleBorder("Status"));
        feedbackPane.setLayout(new MigLayout());
        JScrollPane sbrText = new JScrollPane(feedback);
        feedbackPane.add(sbrText, "push, grow");

        rightPanel = new JPanel(new MigLayout("fill"));
        rightPanel.add(plotTabPane, "grow, wrap");
        rightPanel.add(consolePane, "grow");

        mainPanel.setLayout(new MigLayout("insets 0, debug 1000", "", ""));
        mainPanel.add(configurationPane, "shrinky, top, w 450!");
        mainPanel.add(rightPanel, "spany 5, wrap, grow, pushx, wmin 380");
        mainPanel.add(feedbackPane, "pushy, growy, w 450!");

        JScrollPane contentScrollPane = new JScrollPane(mainPanel);
        contentScrollPane.setBorder(BorderFactory.createEmptyBorder());
        setContentPane(contentScrollPane);
    }

   private static Border getTitleBorder(String title) {
        return BorderFactory.createTitledBorder(null, title, TitledBorder.LEFT, TitledBorder.TOP, new Font("null", Font.BOLD, 12), Color.BLUE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainControl frame = new MainControl();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}