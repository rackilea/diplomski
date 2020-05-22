import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class Test extends JFrame {
    public JList<String> list1, list2;
    public DefaultListModel<String> model1, model2;
    public List<Integer> highlightThese = new ArrayList<Integer>();
    public Test() {
        setPreferredSize(new Dimension(300, 100));
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        model1 = new DefaultListModel<String>();
        model1.addElement("AB");
        model1.addElement("AC");
        model1.addElement("BC");
        model1.addElement("ABC");
        list1 = new JList<String>(model1);
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                list2.clearSelection();
                String str = list1.getSelectedValue();
                String[] parts = str.split("");
                for (int i = 0; i < model2.size(); i++) {
                    for (String p : parts) {
                        if (model2.getElementAt(i).equals(p))
                            list2.addSelectionInterval(i, i);
                    }
                }
            }
        });
        cp.add(list1);
        model2 = new DefaultListModel<String>();
        model2.addElement("A");
        model2.addElement("B");
        model2.addElement("C");
        list2 = new JList<String>(model2);
        list2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        cp.add(list2);
        pack();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }
}