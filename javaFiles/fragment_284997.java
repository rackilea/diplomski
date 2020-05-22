import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class MinPanel {

    public MinPanel() throws HeadlessException, PropertyVetoException {
        createAndShowGUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MinPanel();
                } catch (HeadlessException ex) {
                } catch (PropertyVetoException ex) {
                }

            }
        });
    }

    private void createAndShowGUI() throws HeadlessException, PropertyVetoException {
        JFrame frame = new JFrame();
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JDesktopPane jdp = new JDesktopPane() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 400);
            }
        };

        frame.setContentPane(jdp);
        frame.pack();

        createAndAddInternalFrame(jdp, 0, 0);
        createAndAddInternalFrame(jdp, 200, 0);

        frame.setVisible(true);
    }

    private void createAndAddInternalFrame(final JDesktopPane jdp, int x, int y) throws PropertyVetoException {
        final JInternalFrame jInternalFrame = new JInternalFrame("Test1", false, false, false, false);
        jInternalFrame.setLocation(x, y);

        jInternalFrame.setLayout(new GridLayout(2, 2));
        jInternalFrame.setSize(200, 200);//testing
        JButton jb = new JButton("min");
        jInternalFrame.add(jb);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    jInternalFrame.setIcon(true);
                } catch (PropertyVetoException ex) {
                }

            }
        });
        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) jInternalFrame.getUI()).getNorthPane();
        jInternalFrame.remove(titlePane);


        jInternalFrame.setVisible(true);
        jdp.add(jInternalFrame);
    }
}