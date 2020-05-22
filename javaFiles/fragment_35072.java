import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ListSelectionExample {

    public static void main(String[] args) {
        new ListSelectionExample();
    }

    public ListSelectionExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                DefaultListModel model = new DefaultListModel();
                model.addElement("Bananas on facebook");
                model.addElement("Bananas in pajamas");
                model.addElement("Teddies in space");
                model.addElement("Teddies on twitter");
                model.addElement("Rat on the moon");
                model.addElement("Cow over the moon");
                model.addElement("Facebook pandas");

                JList list = new JList(model);
                for (int index = 0; index < model.getSize(); index++) {
                    String text = model.getElementAt(index).toString().toLowerCase();
                    if (text.contains("facebook") || text.contains("twitter")) {
                        list.addSelectionInterval(index, index);
                    }
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(list));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}