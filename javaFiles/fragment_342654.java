import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

/**
 *
 * @author David
 */
public class Test {

    public Test() {
        createAndShowGui();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel mainHolderPanel = new JPanel(new GridLayout(2, 2));

        for (int i = 0; i < 4; i++) {
            final int num = i;
            OmniPanel op = new OmniPanel(mainHolderPanel, frame) {
                @Override
                public JPanel createPanel() {
                    JPanel p = createSimplePanelInterface();
                    p.add(new JLabel("Panel " + (num + 1)));
                    return p;
                }

                @Override
                void toPanel() {
                    super.toPanel();
                    System.out.println("Frame requested to be brought to panel");
                }
            };
            mainHolderPanel.add(op.getPanel());
        }

        frame.add(mainHolderPanel);

        frame.pack();
        frame.setVisible(true);
    }
}

abstract class OmniPanel {

    protected JFrame frame;
    protected JPanel panel;
    boolean maximized = false;
    private final JComponent owner;
    private final JFrame ownerFrame;

    public OmniPanel(JComponent owner, JFrame con) {
        this.owner = owner;
        initOmniPanel();
        this.ownerFrame = con;
    }

    private void initOmniPanel() {
        panel = createPanel();
        createFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeiconified(WindowEvent we) {
                super.windowDeiconified(we);
                toPanel();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }

    public boolean goFrame() {
        frame.add(panel);
        frame.pack();
        frame.setState(JFrame.ICONIFIED);
        frame.setVisible(true);
        return true;
    }

    protected void createFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    void toPanel() {
        frame.remove(panel);
        frame.dispose();
        owner.add(panel);
        owner.revalidate();
        owner.repaint();
    }

    public JPanel createSimplePanelInterface() {
        JPanel p = new JPanel();
        JButton close = new JButton("X");
        JButton minimize = new JButton("_");
        JButton maximize = new JButton("|-|");
        p.add(close);
        p.add(minimize);
        p.add(maximize);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (maximized) {
                    maximized = false;
                    ownerFrame.setGlassPane(new JComponent() {
                    });
                    ownerFrame.revalidate();
                    ownerFrame.repaint();
                } else {
                    removePanelFromOwner();
                    getFrame().dispose();
                }
            }
        });
        minimize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (maximized) {
                    maximized = false;
                    ownerFrame.setGlassPane(new JComponent() {
                    });
                    owner.add(panel);
                    owner.revalidate();
                    owner.repaint();
                    ownerFrame.revalidate();
                    ownerFrame.repaint();
                } else {
                    removePanelFromOwner();
                    goFrame();
                }
            }
        });
        maximize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (maximized) {
                    return;
                }
                maximized = true;
                removePanelFromOwner();
                ownerFrame.setGlassPane(panel);
                ownerFrame.revalidate();
                ownerFrame.repaint();
                panel.setVisible(true);//or glasspane wont h=show this has been a java glitch of sorts for a while
            }
        });
        p.setBorder(new LineBorder(Color.black));
        return p;
    }

    private void removePanelFromOwner() {
        owner.remove(getPanel());
        owner.revalidate();
        owner.repaint();
    }

    abstract JPanel createPanel();
}