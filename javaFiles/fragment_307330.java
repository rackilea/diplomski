import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class LayoutTest {

    private final JMenuBar menubar = new JMenuBar();
    private final JMenu actiuni = new JMenu("Actiuni");
    private final JMenu contact = new JMenu("Contact");
    private final JMenu help = new JMenu("Help");
    private final JMenuItem ntest = new JMenuItem("Nou test");
    private final JMenuItem vizarh = new JMenuItem("Vizualizare arhiva");
    private final JMenuItem datcon = new JMenuItem("Date de contact");
    private final JMenuItem sendmail = new JMenuItem("Trimite e-mail");
    private final JMenuItem instrut = new JMenuItem("Instructiuni de utilizare");
    private final JButton b1 = new JButton("Incepe testul!");
    private final JButton b2 = new JButton("Vezi arhiva!");
    private final JTextArea ta = new JTextArea("Default text", 5, 30);
    //create JFrame instance
    private final JFrame frame = new JFrame();

    public LayoutTest() {
        initComponents();
    }

    public static void main(String[] args) {
        //creat UI on EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LayoutTest();
            }
        });
    }

    private void initComponents() {
        frame.setTitle("Self-Esteem- Fereastra Principala");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menubar.add(actiuni);
        menubar.add(contact);
        menubar.add(help);
        actiuni.add(ntest);
        actiuni.add(vizarh);
        contact.add(datcon);
        contact.add(sendmail);
        help.add(instrut);

        frame.setJMenuBar(menubar);
        JPanel textAreaJPanel = new JPanel();

        //create button panel with GridLayout(2,1) 
        JPanel buttonJPanel = new JPanel(new GridLayout(2, 1));//new GridLayout(2, 1,10,10) creates gridlayout with horixontal and vertcial spacing of 10

        //add buttons to one panel
        buttonJPanel.add(b1);
        buttonJPanel.add(b2);
        //add text area to textarea jPanel
        textAreaJPanel.add(ta);

        //add textarea panel to west of content pane (BorderLayout by default)
        frame.add(textAreaJPanel, BorderLayout.WEST);

        //add button Panel to EAST of JFrame content pane
        frame.add(buttonJPanel, BorderLayout.EAST);

        frame.pack();

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}