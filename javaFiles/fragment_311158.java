import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class GlueTest extends JComponent {

    private JFrame frame;
    private JToolBar toolbar;
    private JLabel label_1;
    private JTextField textField_1;
    private JLabel label_2;
    private JTextField textField_2;

    public GlueTest() {
        toolbar = new JToolBar();
        toolbar.setFloatable(false);
        toolbar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        toolbar.setAlignmentY(TOP_ALIGNMENT);
        toolbar.add(Box.createHorizontalGlue());

        label_1 = new JLabel(" 1 ");        
        toolbar.add(label_1);
        toolbar.add(Box.createRigidArea(new Dimension(10,1)));

        textField_1 = new JTextField();
        textField_1.setColumns(9);
        textField_1.setMaximumSize(textField_1.getPreferredSize());
        toolbar.add(textField_1);
        toolbar.add(Box.createHorizontalStrut(10));

        label_2 = new JLabel(" 2 ");
        toolbar.add(label_2);
        toolbar.add(Box.createRigidArea(new Dimension(10,1)));

        textField_2 = new JTextField();
        textField_2.setColumns(9);
        textField_2.setMaximumSize(textField_2.getPreferredSize());
        toolbar.add(textField_2);
        toolbar.add(Box.createHorizontalStrut(10));

        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(toolbar, BorderLayout.NORTH);
        frame.add(new JTextArea(10, 40));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GlueTest window = new GlueTest();
            }
        });
    }
}