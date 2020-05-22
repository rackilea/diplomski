import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Test extends JFrame {

    public static void main(String[] args) {
        Test t = new Test();
        final JButton button = new JButton();
        AbstractAction action = new AbstractAction("Hello World!") {

            @Override
            public void actionPerformed(ActionEvent e) {
                button.getModel().setArmed(true);
                button.getModel().setPressed(true);
                Timer t = new Timer(200, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button.getModel().setArmed(false);
                        button.getModel().setPressed(false);
                    }
                });
                t.setRepeats(false);
                t.start();
                // Do action stuff
            }
        };
        button.setAction(action);

        JPanel panel = new JPanel();
        panel.add(button);

        panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("ctrl ENTER"), action);
        panel.getActionMap().put(action, action);

        t.add(panel);

        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.pack();
        t.setVisible(true);
    }
}