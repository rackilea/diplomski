import java.awt.Component;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Ctrl_Down_JList {

    private static void createAndShowUI() {
        String[] items = {"Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat"};
        JList myJList = new JList(items) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void processMouseEvent(MouseEvent e) {
                int modifiers = e.getModifiers() | InputEvent.CTRL_MASK;
                // change the modifiers to believe that control key is down
                int modifiersEx = e.getModifiersEx() | InputEvent.CTRL_MASK;
                // can I use this anywhere?  I don't see how to change the modifiersEx of the MouseEvent
                MouseEvent myME = new MouseEvent((Component) e.getSource(), e.getID(), e.getWhen(), modifiers, e.getX(),
                        e.getY(), e.getXOnScreen(), e.getYOnScreen(), e.getClickCount(), e.isPopupTrigger(), e.getButton());
                super.processMouseEvent(myME);
            }
        };
        JFrame frame = new JFrame("Ctrl_Down_JList");
        frame.getContentPane().add(new JScrollPane(myJList));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowUI();
            }
        });
    }