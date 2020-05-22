import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComboTest extends JPanel implements ActionListener, Runnable {

    private final JComboBox combo1 = new JComboBox(
        new String[]{"Course 1", "Course 2", "Course 3"});
    private final JComboBox combo2 = new JComboBox();
    private ComboBoxModel[] models = new ComboBoxModel[3];

    public ComboTest() {
        models[0] = new DefaultComboBoxModel(
            new String[]{"A1", "A2"});
        models[1] = new DefaultComboBoxModel(
            new String[]{"B1", "B2", "B3", "B4"});
        models[2] = new DefaultComboBoxModel(
            new String[]{"C1", "C2"});

        combo2.setModel(models[0]);
        this.add(combo1);
        this.add(combo2);
        combo1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = combo1.getSelectedIndex();
        combo2.setModel(models[i]);
    }

    @Override
    public void run() {
        JFrame f = new JFrame("ComboTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new ComboTest());
    }
}