import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @see https://stackoverflow.com/q/8703464/230513
 * @see https://stackoverflow.com/questions/6803976
 */
public class Adder extends JPanel {

    private static final int MAX = 3;
    private final List<JFormattedTextField> fields =
        new ArrayList<JFormattedTextField>();
    private final NumberFormat format = NumberFormat.getNumberInstance();
    private final JFormattedTextField sum = new JFormattedTextField(format);

    public Adder() {
        this.setLayout(new GridLayout(0, 1));
        for (int i = 0; i < MAX; i++) {
            JFormattedTextField tf = init();
            fields.add(tf);
            this.add(tf);
        }
        sum.setHorizontalAlignment(JFormattedTextField.RIGHT);
        sum.setEditable(false);
        sum.setFocusable(false);
        this.add(sum);
    }

    private JFormattedTextField init() {
        JFormattedTextField jtf = new JFormattedTextField(format);
        jtf.setValue(0);
        jtf.setHorizontalAlignment(JFormattedTextField.RIGHT);
        jtf.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        update();
                    }
                });
            }
        });
        jtf.addPropertyChangeListener("value", new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent e) {
                update();
            }
        });
        return jtf;
    }

    private void update() {
        long total = 0;
        for (JFormattedTextField tf : fields) {
            Number v = (Number) tf.getValue();
            total += v.longValue();
        }
        sum.setValue(total);
    }

    private void display() {
        JFrame f = new JFrame("Adder");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Adder().display();
            }
        });
    }
}