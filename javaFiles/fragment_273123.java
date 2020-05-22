import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 * @see http://stackoverflow.com/a/11007109/230513
 */
public class TabEdit extends JPanel {

    private static final int MAX = 5;
    private static final String NAME = "Tab ";
    private final JTabbedPane pane = new JTabbedPane();

    public TabEdit() {
        for (int i = 0; i < MAX; i++) {
            pane.add(NAME + String.valueOf(i), new TabContent(i));
        }
        this.add(pane);
    }

    private class TabContent extends JPanel {

        private TabContent(final int i) {
            final JTextField jtf = new JTextField(
                "Please edit the name of " + NAME + String.valueOf(i));
            this.add(jtf);
            jtf.addActionListener(new AbstractAction() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    pane.setTitleAt(i, jtf.getText());
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(320, 120);
        }
    }

    private void display() {
        JFrame f = new JFrame("TabEdit");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TabEdit().display();
            }
        });
    }
}