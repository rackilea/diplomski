import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class TestFloatingToolBar {

    public static void main(String[] args) {
        new TestFloatingToolBar();
    }

    public TestFloatingToolBar() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final JFrame frame = new JFrame("Test");

                final JToolBar tb = new JToolBar();
                tb.add(new JButton("Pop"));
                tb.setFloatable(true);

                tb.addAncestorListener(new AncestorListener() {
                    @Override
                    public void ancestorAdded(AncestorEvent event) {
                        tell();
                        if (SwingUtilities.getWindowAncestor(tb).equals(frame)) {
                            System.out.println("...In Main Frame");
                        } else {
                            System.out.println("...Maybe floating");
                        }
                    }

                    @Override
                    public void ancestorRemoved(AncestorEvent event) {
                        tell();
                        if (SwingUtilities.getWindowAncestor(tb).equals(frame)) {
                            System.out.println("...In Main Frame");
                        } else {
                            System.out.println("...Maybe floating");
                        }
                    }

                    @Override
                    public void ancestorMoved(AncestorEvent event) {
                    }
                });

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(tb, BorderLayout.NORTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public void tell() {
        Exception exp = new Exception();
        StackTraceElement[] stackTrace = exp.getStackTrace();
        System.out.println(stackTrace[1].getMethodName());
    }

}