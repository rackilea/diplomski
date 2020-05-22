import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolTip;
import javax.swing.Timer;
import javax.swing.ToolTipManager;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class DynamicToolTipTest {

    private JPanel panel = new MyPanel();
    private JFrame frame = new JFrame("DynamicToolTipTest");

    public DynamicToolTipTest() {
        ToolTipManager ttm = ToolTipManager.sharedInstance();
        ttm.setInitialDelay(200);
        ttm.setDismissDelay(10000);
        panel.setToolTipText("Text 1");
        final Timer timer = new Timer(50, new ActionListener() {
            private int id = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                ++id;
                panel.setToolTipText("Text " + id);
            }
        });
        timer.start();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocation(150, 100);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DynamicToolTipTest();
            }
        });
    }

    private static final class MyPanel extends JPanel {

        private static final long serialVersionUID = 1L;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 200);
        }

        @Override
        public JToolTip createToolTip() {
            final JToolTip tip = super.createToolTip();
            final PropertyChangeListener updater = new PropertyChangeListener() {
                @Override
                public void propertyChange(final PropertyChangeEvent e) {
                    if (e.getNewValue() != null) {
                        tip.setTipText((String) e.getNewValue());
                        tip.repaint();
                    }
                }
            };
            tip.addAncestorListener(new AncestorListener() {
                @Override
                public void ancestorAdded(AncestorEvent event) {
                    //start listening for tip text changes only after the tip 
                    //is displayed, i.e. the tip is added to the component hierarchy
                    MyPanel.this.addPropertyChangeListener(TOOL_TIP_TEXT_KEY, updater);
                }

                @Override
                public void ancestorRemoved(AncestorEvent event) {
                    //stop listening for tip text changes once the tip is no longer 
                    //displayed, i.e. the tip is removed from the component hierarchy
                    MyPanel.this.removePropertyChangeListener(TOOL_TIP_TEXT_KEY, updater);
                }

                @Override
                public void ancestorMoved(AncestorEvent event) {
                }
            });
            return tip;
        }
    }
}