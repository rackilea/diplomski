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
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Test {

    public Test() throws HeadlessException, PropertyVetoException {
        createAndShowGUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Test();
                } catch (HeadlessException ex) {
                    ex.printStackTrace();
                } catch (PropertyVetoException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

    private void createAndShowGUI() throws HeadlessException, PropertyVetoException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JDesktopPane jdp = new JDesktopPane() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(600, 400);
            }
        };

        frame.setContentPane(jdp);
        frame.pack();

        createAndAddInternalFrame(jdp, 0, 0);
        createAndAddInternalFrame(jdp, 300, 0);
        createAndAddInternalFrame(jdp, 0, 200);

        frame.setVisible(true);
    }

    private void createAndAddInternalFrame(final JDesktopPane jdp, int x, int y) throws PropertyVetoException {
        final JInternalFrame jInternalFrame = new JInternalFrame("Test1", true, true, true, true);
        jInternalFrame.setLocation(x, y);

        JPanel jp = new JPanel();

        JButton jb = new JButton("min");
        JButton jb2 = new JButton("max/restore");
        JButton jb3 = new JButton("close");

        jInternalFrame.setLayout(new GridLayout(2, 2));

        jp.add(jb);
        jp.add(jb2);
        jp.add(jb3);

        jInternalFrame.add(jp);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (jInternalFrame.getLayer() == JDesktopPane.FRAME_CONTENT_LAYER) {
                        jdp.remove(jInternalFrame);
                        jdp.add(jInternalFrame, JDesktopPane.DEFAULT_LAYER);
                        jdp.revalidate();
                        jdp.repaint();
                    }
                    jInternalFrame.pack();
                    jInternalFrame.setIcon(true);
                } catch (PropertyVetoException ex) {
                    ex.printStackTrace();
                }

            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (jInternalFrame.isMaximum()) {//restore
                        jInternalFrame.pack();
                    } else {//maximize
                        jInternalFrame.setMaximum(true);
                    }
                    jdp.remove(jInternalFrame);
                    jdp.add(jInternalFrame, JDesktopPane.FRAME_CONTENT_LAYER);
                    jdp.revalidate();
                    jdp.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    jInternalFrame.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) jInternalFrame.getUI()).getNorthPane();
        jInternalFrame.remove(titlePane);

        jInternalFrame.pack();
        jInternalFrame.setVisible(true);

        jdp.add(jInternalFrame);
    }
}