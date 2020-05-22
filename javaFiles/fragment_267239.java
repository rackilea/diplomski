import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ScrollFocusedField {

    public static void main(String[] args) {
        new ScrollFocusedField();
    }

    public ScrollFocusedField() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                FocusAdapter fh = new FocusAdapter() {

                    @Override
                    public void focusGained(FocusEvent e) {
                        JComponent comp = (JComponent) e.getComponent();
                        System.out.println("FocusGained");
                        Rectangle bounds = comp.getBounds();
                        bounds.setLocation(SwingUtilities.convertPoint(comp, bounds.getLocation(), comp.getParent()));

                        JComponent parent = (JComponent) comp.getParent();
                        parent.scrollRectToVisible(comp.getBounds());
                    }

                };

                JPanel panel = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                for (int index = 0; index < 100; index++) {
                    gbc.fill = GridBagConstraints.NONE;
                    gbc.weightx = 0;
                    gbc.gridx = 0;
                    gbc.gridy = index;
                    panel.add(new JLabel(Integer.toString(index)), gbc);

                    JTextField field = new JTextField();
                    field.addFocusListener(fh);
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    gbc.weightx = 1;
                    gbc.gridx = 1;
                    panel.add(field, gbc);
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(panel));
                frame.setSize(200, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}