import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Spinner {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Spinner demo");
               //10 is init value, 0 is minimum, 20 maximum and 1 is step
                SpinnerModel model = new SpinnerNumberModel(10, 0, 20, 1);
                JSpinner spinner = new JSpinner(model);
                spinner.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        JSpinner s = (JSpinner)e.getSource();
                        int val = (int)s.getValue();
                        System.out.println(val);
                    }
                });

                frame.add(spinner);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}