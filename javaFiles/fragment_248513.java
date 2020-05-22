import java.awt.*;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class MyFlowLayout {

    static JRadioButton cb1 = new JRadioButton("Left");
    static JRadioButton cb2 = new JRadioButton("Center");
    static JRadioButton cb3 = new JRadioButton("Right");
    static JFrame frm = new JFrame("Frame Title");

    public MyFlowLayout() {
        frm.setLayout(new FlowLayout());
        ButtonGroup cg = new ButtonGroup();
        cg.add(cb1);
        cg.add(cb2);
        cg.add(cb3);
        cb1.addItemListener(new ItmLis());
        cb2.addItemListener(new ItmLis());
        cb3.addItemListener(new ItmLis());
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // or WindowListener too
        /*frm.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
         System.exit(0);
         }
         });*/
        frm.setSize(400, 200);
        frm.add(cb1);
        frm.add(cb2);
        frm.add(cb3);
        frm.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFlowLayout fs = new MyFlowLayout();
            }
        });
    }

    private class ItmLis implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (cb1.isSelected() == true) {
                frm.setLayout(new FlowLayout(FlowLayout.LEFT));
                validateLayout();
            } else if (cb2.isSelected() == true) {
                frm.setLayout(new FlowLayout(FlowLayout.CENTER));
                validateLayout();
            } else if (cb3.isSelected() == true) {
                frm.setLayout(new FlowLayout(FlowLayout.RIGHT));
                validateLayout();
            }
        }

        public void validateLayout() {
            frm.validate();
            frm.repaint();
        }
    }
}