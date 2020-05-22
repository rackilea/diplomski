import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class TestPanel extends JPanel {

    private TestPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        Map<String, DefaultComboBoxModel> map = new HashMap<String,     DefaultComboBoxModel>();
        for (int i = 0; i < 5; i++) {
            JComboBox combo = new JComboBox();
            add(combo);
            map.put("combo" + i, (DefaultComboBoxModel) combo.getModel());
        }

        add(new JButton(new AbstractAction("fill me") {

            @Override
            public void actionPerformed(ActionEvent e) {
                new MyWorker(map).run();
            }
        }));

    }

    private class MyWorker extends SwingWorker<Void, String[]> {

        private final Map<String, DefaultComboBoxModel> map;

        public MyWorker(Map<String, DefaultComboBoxModel> map) {
            this.map = map;
        }

        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 0; i < 20; i++) {
                String[] cell = new String[2];
                cell[0] = "combo" + i % 5;
                cell[1] = "value " + i;
                publish(cell);
            }
            return null;
        }

        @Override
        protected void process(List<String[]> chunks) {
            for (String[] chunk : chunks) {
                map.get(chunk[0]).addElement(chunk[1]);
            }
        }

    };

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the 
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("SwingWorker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new TestPanel();
        frame.setContentPane(panel);

        // Display the window.
        frame.setSize(200, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}