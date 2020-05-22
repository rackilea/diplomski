import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new MainFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private Panel1 storyPanel;
//  private Panel2 statsPanel;
//  private Panel3 commandsPanel;

    public MainFrame(String title) {
        super(title);

        storyPanel = new Panel1();

        Container p = getContentPane();

        p.add(storyPanel, BorderLayout.WEST);
        p.add(new JLabel("East"), BorderLayout.EAST);
        p.add(new JLabel("South"), BorderLayout.SOUTH);

    }

    public class Panel1 extends JPanel {

        public Panel1() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            //Set size of Panel1
            setBorder(BorderFactory.createLineBorder(Color.black));

            //Adding JTextArea and adding settings to it
            JTextArea storyLine = new JTextArea(20, 20);
            storyLine.setLineWrap(true);
            storyLine.setWrapStyleWord(true);
            storyLine.setEditable(false);

            //Adding JScrollPane to the JTextArea and making it have a vertical scrollbar
            JScrollPane scroll = new JScrollPane(storyLine);
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            //GridBagConstraints setup for components
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1;
            gbc.weighty = 1;
            add(scroll, gbc);
        }
    }
}