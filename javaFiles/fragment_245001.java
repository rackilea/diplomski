import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ControlPanel extends JFrame {

    JScrollPane userspane;
    JList list;
    DefaultListModel model = new DefaultListModel();
    JScrollPane consolepane;
    JTextArea console = new JTextArea(20, 50);
    JTextArea jta = new JTextArea(6, 50);
    JPanel panel = new JPanel();

    JButton kick = new JButton("Kick");
    JButton ban = new JButton("Ban");
    JButton info = new JButton("Info");

    public ControlPanel() {
        // create our list of players
        list = new JList(model);

        // create our scroll panes
        userspane = new JScrollPane(list);
        consolepane = new JScrollPane(console);

        // add to panel
        panel.add(userspane, BorderLayout.CENTER);
        panel.add(kick);
        panel.add(ban);
        panel.add(info);
        panel.add(consolepane, BorderLayout.CENTER);

        add(panel);
        pack();
        setTitle("RuneShadows CP");
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new ControlPanel();
            }
        });
    }
}