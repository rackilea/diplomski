import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Driver {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ListFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }

    private static class ListFrame extends JFrame {

        private final String[] data = {"A", "B", "C"};
        private final DefaultListModel model = new DefaultListModel();
        private final JList<String> list = new JList<>(model);
        private final JButton addButton = new JButton("Add");

        public ListFrame() {
            for (String s : data) {
                model.addElement(s);
            }
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            add(new JScrollPane(list), BorderLayout.CENTER);
            add(addButton, BorderLayout.SOUTH);
            addButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    String newEntry = JOptionPane.showInputDialog("Add new entry.");
                    model.addElement(newEntry);
                }
            });
            list.addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        System.out.println(e.getFirstIndex() + " " + e.getLastIndex());
                    }
                }
            });
        }
    }
}