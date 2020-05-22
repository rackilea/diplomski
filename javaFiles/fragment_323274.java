import component.Laf;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * @see https://stackoverflow.com/a/16121288/230513
 */
public class JToolBarTest {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
        // https://stackoverflow.com/a/11949899/230513
        f.add(Laf.createToolBar(f));
        f.add(createBar());
        f.add(createBar());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JToolBar createBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.add(createPanel());
        toolBar.addSeparator();
        toolBar.add(createPanel());
        return toolBar;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Panel"));
        Action buttonAction = new AbstractAction("Button"){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand()
                    + " " + e.getSource().hashCode());
            }
        };
        panel.add(new JButton(buttonAction));
        panel.add(new JButton(buttonAction));
        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JToolBarTest().display();
            }
        });
    }
}