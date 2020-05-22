package Project;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Test4 {

    private JDesktopPane pane;

    public static void main(String[] args) {
        new Test4();// there was a little change here
    }
    private int xpos = 0;
    private int ypos = 0;

    public Test4() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
                pane = new Test4.DesktopPane() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(400, 400);
                    }
                };
                pane.add(newInternalFrame());
                pane.add(newInternalFrame());
                pane.add(newInternalFrame());

                JFrame frame = new JFrame();
                frame.add(pane);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }

    public JInternalFrame newInternalFrame() {
        final JInternalFrame inf = new JInternalFrame("Blah", true, true, true, true);
        inf.setLocation(xpos, ypos);
        inf.setSize(200, 100);
        inf.setVisible(true);

        xpos += 50;
        ypos += 50;

        JPanel jp = new JPanel();
        JLabel jl = new JLabel("panel" + xpos);

        JButton jb = new JButton("_");
        JButton jb2 = new JButton("[]");
        JButton jb3 = new JButton("X");

        inf.setLayout(new GridLayout(2, 2));
        jp.add(jl);
        jp.add(jb);
        jp.add(jb2);
        jp.add(jb3);

        inf.add(jp);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (inf.getLayer() == JDesktopPane.FRAME_CONTENT_LAYER) {
                        pane.remove(inf);
                        pane.add(inf, JDesktopPane.DEFAULT_LAYER);
                        pane.revalidate();
                        pane.repaint();
                    }
                    inf.pack();
                    inf.setIcon(true);
                } catch (PropertyVetoException ex) {
                    ex.printStackTrace();
                }

            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (inf.isMaximum()) {//restore
                        inf.pack();
                    } else {//maximize
                        inf.setMaximum(true);

                    }
                    pane.remove(inf);
                    pane.add(inf, JDesktopPane.FRAME_CONTENT_LAYER);
                    pane.revalidate();
                    pane.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    inf.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });


        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) inf.getUI()).getNorthPane();
        inf.remove(titlePane);
        return inf;
    }

    public class DesktopPane extends JDesktopPane {

        @Override
        public void doLayout() {
            super.doLayout();
            List<Component> icons = new ArrayList<Component>(25);
            int maxLayer = 0;

            for (Component comp : getComponents()) {
                if (comp instanceof JInternalFrame.JDesktopIcon) {
                    icons.add(comp);
                    maxLayer = Math.max(getLayer(comp), maxLayer);
                }
            }

            maxLayer++;
            int x = 0;
            for (Component icon : icons) {

                int y = getHeight() - icon.getHeight();
                icon.setLocation(x, y);
                x += icon.getWidth();
                setLayer(icon, maxLayer);
            }
        }
    }
}