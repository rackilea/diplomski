import java.awt.*;
import javax.swing.*;
import edu.umd.cs.piccolo.*;
import edu.umd.cs.piccolo.nodes.*;
import edu.umd.cs.piccolox.event.*;

public class TestSelectHandle {

    private static void createAndShowUI() {
        JFrame frame = new JFrame("TestSelectHandle");
        PCanvas canvas = new PCanvas() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 200);
            }
        };

        final JTextArea output = new JTextArea(5, 20);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                canvas, output);
        frame.add(splitPane);

        final PNode blueRect = PPath.createRectangle(50, 50, 50, 50);
        blueRect.setPaint(Color.BLUE);
        canvas.getLayer().addChild(blueRect);

        final PNode redRect = PPath.createRectangle(110, 110, 50, 50);
        redRect.setPaint(Color.RED);
        canvas.getLayer().addChild(redRect);

        canvas.removeInputEventListener(canvas.getPanEventHandler());
        canvas.removeInputEventListener(canvas.getZoomEventHandler());

        PSelectionEventHandler selectionHandler = new PSelectionEventHandler(
                canvas.getLayer(), canvas.getLayer());
        canvas.addInputEventListener(selectionHandler);
        canvas.getRoot().getDefaultInputManager()
                .setKeyboardFocus(selectionHandler);

        PNotificationCenter.defaultCenter().addListener(
                new NodeSelectionListener(output), "selectionChanged",
                PSelectionEventHandler.SELECTION_CHANGED_NOTIFICATION,
                selectionHandler);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static class NodeSelectionListener {
        private JTextArea output;

        public NodeSelectionListener(JTextArea output) {
            this.output = output;
        }

        public void selectionChanged(final PNotification notfication) {
            output.append("selection changed\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}