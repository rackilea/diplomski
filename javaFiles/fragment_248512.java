import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;

public class MyFlowLayout {

    static Checkbox cb1 = new Checkbox("Left");
    static Checkbox cb2 = new Checkbox("Center");
    static Checkbox cb3 = new Checkbox("Right");
    static Frame frm = new Frame("Frame Title");

    public MyFlowLayout() {
        frm.setLayout(new FlowLayout());
        CheckboxGroup cg = new CheckboxGroup();
        cb1.setCheckboxGroup(cg);
        cb2.setCheckboxGroup(cg);
        cb3.setCheckboxGroup(cg);
        cb1.addItemListener(new ItmLis());
        cb2.addItemListener(new ItmLis());
        cb3.addItemListener(new ItmLis());
        frm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
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
            if (cb1.getState() == true) {
                frm.setLayout(new FlowLayout(FlowLayout.LEFT));
                validateLayout();
            } else if (cb2.getState()) {
                frm.setLayout(new FlowLayout(FlowLayout.CENTER));
                validateLayout();
            } else if (cb3.getState()) {
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