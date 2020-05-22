import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class Main {
    public static void main(String[] argv) throws Exception {

        JButton component = new JButton();
        MyAction action = new MyAction();
        component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F2"),
            action.getValue(Action.NAME));
    }
}

class MyAction extends AbstractAction {
    public MyAction() {
        super("my action");
    }

    public void actionPerformed(ActionEvent e) {
        //Here goes the code where the button does something
        System.out.println("hi");//In this case we print hi
    }
}