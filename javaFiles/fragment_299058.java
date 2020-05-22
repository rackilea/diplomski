import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/** @see https://stackoverflow.com/a/44191328/230513 */
public class ComboListTest extends JPanel implements ActionListener, Runnable {

    private final JComboBox<String> combo = new JComboBox<>(
        new String[]{"Year 1", "Year 2", "Year 3"});
    private final JList<String> list = new JList<>();
    private List<DefaultListModel<String>> models = new ArrayList<>();

    public ComboListTest() {
        super(new GridLayout(0, 1));
        models.add(new DefaultListModel<String>());
        models.get(0).addElement("A1");
        models.get(0).addElement("A2");
        models.add(new DefaultListModel<String>());
        models.get(1).addElement("B1");
        models.get(1).addElement("B2");
        models.get(1).addElement("B3");
        models.get(1).addElement("B4");
        models.add(new DefaultListModel<String>());
        models.get(2).addElement("C1");
        models.get(2).addElement("C2");

        list.setModel(models.get(0));
        this.add(combo);
        this.add(new JScrollPane(list));
        combo.addActionListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(320, 240);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = combo.getSelectedIndex();
        list.setModel(models.get(i));
    }

    @Override
    public void run() {
        JFrame f = new JFrame("ComboListTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new ComboListTest());
    }
}