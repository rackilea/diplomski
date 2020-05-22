import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseWheelTest extends JPanel implements MouseWheelListener {
    private final static String SOME_ACTION = "control 1";

    public MouseWheelTest() {
        super(new BorderLayout());

        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        textArea.addMouseWheelListener(this);

        Action someAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("do some action");
            }
        };

        // Control A is used by a text area so try a different key
        textArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(SOME_ACTION), SOME_ACTION);
        textArea.getActionMap().put(SOME_ACTION, someAction);
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.isControlDown()) {
            if (e.getWheelRotation() < 0) {
                JComponent component = (JComponent)e.getComponent();
                Action action = component.getActionMap().get(SOME_ACTION);
                if (action != null)
                    action.actionPerformed( null );
            } else {
                System.out.println("scrolled down");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("MouseWheelTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new MouseWheelTest() );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}