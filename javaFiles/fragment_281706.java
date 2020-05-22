import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListDemo extends JFrame {

    public JListDemo() {

        setSize(new Dimension(300, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        final JLabel label = new JLabel("Update");
        String[] data = { "one", "two", "three", "four" };
        final JList dataList = new JList(data);

        dataList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                  label.setText(dataList.getSelectedValue().toString());
                }
            }
        });
        add(dataList);
        add(label);

        setVisible(true);

    }

    public static void main(String args[]) {
        new JListDemo();
    }

}