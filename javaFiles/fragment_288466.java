import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.lang.reflect.InvocationTargetException;
import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Test extends JApplet {

    JPanel mainpanel = new JPanel();
    JPanel upanel = new JPanel();
    JPanel dpanel = new JPanel();
    JPanel ulpanel = new JPanel();
    JPanel urpanel = new JPanel();
    JPanel dlpanel = new JPanel();
    JPanel drpanel = new JPanel();
    JLabel l1 = new JLabel("Label 1");
    JLabel l2 = new JLabel("Label 2");
    JLabel l3 = new JLabel("Label 3");
    JLabel l4 = new JLabel("Label 4");
    JTextField tb1 = new JTextField();
    JTextField tb2 = new JTextField();
    JTextField tb3 = new JTextField();
    JTextArea ta1 = new JTextArea();

    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    initComponents();
                }
            });
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        mainpanel.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
        ulpanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        urpanel.setBorder(BorderFactory.createLineBorder(Color.green, 2));
        upanel.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        mainpanel.setLayout(new GridLayout(1, 1));
        upanel.setLayout(new GridLayout(1, 2));
        urpanel.setLayout(new BorderLayout());
        urpanel.add(ta1, BorderLayout.CENTER);
        ulpanel.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.ipadx = 2;
        g.ipady = 2;
        g.insets = new Insets(2, 2, 2, 2);
        //      g.anchor = GridBagConstraints.EAST;
        g.gridx = 0;
        g.gridy = 0;
        ulpanel.add(l1, g);
        g.gridx = 0;
        g.gridy = 1;
        ulpanel.add(l2, g);
        g.gridx = 2;
        g.gridy = 1;
        ulpanel.add(l3, g);
        g.gridx = 0;
        g.gridy = 2;
        ulpanel.add(l4, g);

        g.gridwidth = GridBagConstraints.REMAINDER;
        g.fill = GridBagConstraints.HORIZONTAL;
        //      g.anchor = GridBagConstraints.WEST;
        g.weightx = 1;
        g.gridx = 1;
        g.gridy = 0;
        ulpanel.add(tb1, g);
        g.gridwidth = 1;
        g.gridx = 1;
        g.gridy = 1;
        ulpanel.add(tb2, g);
        g.gridx = 3;
        g.gridy = 1;
        ulpanel.add(tb3, g);

        upanel.add(ulpanel);
        upanel.add(urpanel);
        mainpanel.add(upanel);
        add(mainpanel);
    }
}