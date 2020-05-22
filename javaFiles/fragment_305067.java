import java.awt.EventQueue;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/** @see https://stackoverflow.com/questions/7781781 */
public class OptionList {

    private void display() {
        String[] items = {
            "11327|933393|2", "11833|938393|1", "11934|483393|7"
        };
        JList list = new JList(items);
        JPanel panel = new JPanel();
        panel.add(list);
        JOptionPane.showMessageDialog(null, panel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new OptionList().display();
            }
        });
    }
}