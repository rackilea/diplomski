import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                DefaultListModel model = new DefaultListModel();
                model.addElement(new ImageIcon("mt01.jpg"));
                model.addElement(new ImageIcon("mt02.jpg"));
                model.addElement(new ImageIcon("mt03.jpg"));

                JList list = new JList(model);
                list.setVisibleRowCount(3);
                list.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (!e.getValueIsAdjusting()) {
                            System.out.println(list.getSelectedIndex());
                        }
                    }
                });

                JFrame frame = new JFrame("Test");
                frame.add(new JScrollPane(list));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}