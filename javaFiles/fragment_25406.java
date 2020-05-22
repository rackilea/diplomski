import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ListString extends JFrame {

    private static final long serialVersionUID = 1L;
    private DefaultListModel model = new DefaultListModel();
    private int i = 01;

    public ListString() {
        model.addElement(("one" + i++));
        model.addElement(("two" + i++));
        model.addElement(("three" + i++));
        model.addElement(("four" + i++));
        JList list = new JList(model);
        add(new JScrollPane(list));
        JButton btn = new JButton("Remove All Rows :");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                model.removeAllElements();
            }
        });
        add(btn, BorderLayout.SOUTH);
        JButton btn1 = new JButton("Add New Rows:");
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                model.addElement(("one" + i++));
                model.addElement(("two" + i++));
                model.addElement(("three" + i++));
                model.addElement(("four" + i++));
            }
        });
        add(btn1, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        UIManager.getLookAndFeelDefaults().put("List.selectionBackground", Color.red);
        ListString frame = new ListString();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}