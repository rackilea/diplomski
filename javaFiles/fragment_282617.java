import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestRemover {

    public static void main(String[] args) {
        new TestRemover();
    }

    public TestRemover() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTextArea lastFocused;
        private FocusHandler focusHandler;
        private JPanel fields;
        private JPanel buttons;

        public TestPane() {
            setLayout(new BorderLayout());
            focusHandler = new FocusHandler();
            fields = new JPanel(new GridBagLayout());
            buttons = new JPanel();
            JButton add = new JButton("Add");
            JButton remove = new JButton("Remove");
            buttons.add(add);
            buttons.add(remove);
            add(buttons, BorderLayout.SOUTH);
            add(new JScrollPane(fields));

            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextArea ta = new JTextArea(10, 10);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    gbc.weightx = 1;
                    gbc.gridwidth = GridBagConstraints.REMAINDER;
                    fields.add(new JScrollPane(ta), gbc);
                    ta.addFocusListener(focusHandler);

                    fields.revalidate();
                    fields.repaint();
                }
            });
            remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (lastFocused != null) {

                        // ViewPort.ScrollPane
                        Container scollPane = lastFocused.getParent().getParent();
                        Container parent = scollPane.getParent();
                        parent.remove(scollPane);
                        lastFocused = null;
                        parent.revalidate();
                        parent.repaint();

                    }
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public class FocusHandler extends FocusAdapter {

            @Override
            public void focusGained(FocusEvent e) {
                if (e.getComponent() instanceof JTextArea) {

                    lastFocused = (JTextArea) e.getComponent();

                }
            }                
        }            
    }        
}