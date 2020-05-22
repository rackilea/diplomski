import java.awt.EventQueue;
import javax.swing.JFrame;
import com.alee.laf.WebLookAndFeel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class demo {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WebLookAndFeel.install();
                    demo window = new demo();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public demo() {
        initialize();
    }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("d/MM/yyyy");
        dateChooser.setBounds(74, 193, 181, 30);
        JTextFieldDateEditor editor=(JTextFieldDateEditor)dateChooser.getDateEditor();
        editor.setEditable(false);
        frame.getContentPane().add(dateChooser);
        frame.repaint();
    }
}