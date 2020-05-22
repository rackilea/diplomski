import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;

public class TestEditorPane {
    private JEditorPane editorPane;

    public static class CombinedAction implements ActionListener {
        private final ActionListener action1;
        private final ActionListener action2;

        public CombinedAction(ActionListener action1, ActionListener action2) {
            super();
            this.action1 = action1;
            this.action2 = action2;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (action1 != null) {
                action1.actionPerformed(e);
            }
            if (action2 != null) {
                action2.actionPerformed(e);
            }
        }

    }

    public TestEditorPane() {
    }

    private void initUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JTEXTBOX
        editorPane = new JEditorPane();
        KeyStroke ctrlV = KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK);
        final ActionListener ctrlVAction = editorPane.getActionForKeyStroke(ctrlV);
        editorPane.registerKeyboardAction(new CombinedAction(ctrlVAction, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("This is my action on CTRL+V");
            }
        }), ctrlV, JComponent.WHEN_FOCUSED);
        // JSCROLLPANE
        JScrollPane scroll1 = new JScrollPane(editorPane);
        scroll1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scroll1);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    TestEditorPane test = new TestEditorPane();
                    test.initUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}