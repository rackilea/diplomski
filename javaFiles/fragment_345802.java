import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.SwingWorker;
import java.util.Arrays;
import java.util.List;
public class ListUpdateTest extends JPanel {

    private JList list;
    private DefaultListModel model;

    public ListUpdateTest () {
        model = new DefaultListModel();
        list = new JList(model);

        setLayout(new BorderLayout());

        add(new JScrollPane(list),BorderLayout.CENTER);
        (new UpdateRunner()).execute();
    }

    public void updateList (List<String> entries) {
        model.removeAllElements();
        for (String entry : entries) {
            model.addElement(entry);
        }
    }
    private class UpdateRunner extends SwingWorker<List<String>, List<String>>{

        @Override
        public List<String> doInBackground() {
            while (true) {
                int entryCount = model.size()+1;

                System.out.println("Should be "+entryCount+" entries");

                String [] entries = new String [entryCount];

                for (int i=0;i<entries.length;i++) {
                    entries[i] = "Entry "+i;
                }

                publish(Arrays.asList(entries));

                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {}
            }
            return null;
        }
        @Override
        protected void process(List<List<String>> entries) {
            for (List<String> entry : entries) {
                updateList(entry);
            }
        }
        @Override
        protected void done() {
            updateList(Arrays.asList("done"));
        }
    }

    public static void main (String [] args) {

        JDialog dialog = new JDialog();
        dialog.setContentPane(new ListUpdateTest());
        dialog.setSize(200,400);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setVisible(true);
        System.exit(0);
    }

}