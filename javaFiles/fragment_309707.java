import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame implements ActionListener {

    JMenuItem addInternalFrame;
    JMenuItem removeInternalFrame;
    JTabbedPane tabbedPane;
    JPanel tabPanel1;
    JPanel tabPanel2;
    JDesktopPane tabDesktopPane1;
    JDesktopPane tabDesktopPane2;
    boolean tab1Added = false;

    public MainFrame(final String title) {

        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabbedPane = initComponents();
        this.setJMenuBar(initMenuBar());
        this.getContentPane().add(tabbedPane);
        this.setSize(new Dimension(1024, 768));
        this.setVisible(true);
    }

    private JTabbedPane initComponents() {

        JTabbedPane jTabbedPane = new JTabbedPane();

        tabDesktopPane1 = new JDesktopPane();
        tabDesktopPane2 = new JDesktopPane();
        tabPanel1 = new JPanel();
        tabPanel1.add(tabDesktopPane1);
        tabPanel2 = new JPanel();
        tabPanel2.add(tabDesktopPane2);

        jTabbedPane.setTabPlacement(JTabbedPane.TOP);
        jTabbedPane.addTab("Tab1", tabDesktopPane1);
        jTabbedPane.addTab("Tab2", tabDesktopPane2);

        return jTabbedPane;
    }

    private JMenuBar initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        addInternalFrame = new JMenuItem("add new JInternalFrame");
        addInternalFrame.addActionListener(this);

        removeInternalFrame = new JMenuItem("remove InternalFrame");
        removeInternalFrame.addActionListener(this);

        fileMenu.add(addInternalFrame);
        fileMenu.add(removeInternalFrame);
        menuBar.add(fileMenu);

        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(addInternalFrame)) {
            JInternalFrame internalFrame = new JInternalFrame("Internal Frame", true, true, true);
            internalFrame.setSize(new Dimension(250, 150));
            internalFrame.add(new JLabel("Demo with JInternalFrames"));
            internalFrame.setVisible(true);

            if(tab1Added) {
                tabDesktopPane2.add(internalFrame);
                tabbedPane.setSelectedComponent(tabDesktopPane2);
                tab1Added = !tab1Added;
            } else {
                tabDesktopPane1.add(internalFrame);
                tabbedPane.setSelectedComponent(tabDesktopPane1);
                tab1Added = !tab1Added;
            }
        }
        if(e.getSource().equals(removeInternalFrame)) {
            removeInternalFrame();
        }
    }

    private void removeInternalFrame() {
        if(tab1Added) {
            if(tabDesktopPane1.getComponentCount() <= 0) {
                JOptionPane.showConfirmDialog(getParent(), "Sorry, there are no JInternalFrames anymore displayed on this Desktop!");
            } else {
                tabDesktopPane1.remove(tabDesktopPane1.getComponentCount()-1);
                tabbedPane.setSelectedComponent(tabDesktopPane1);
                tab1Added = !tab1Added;
            }

        } else {
            if(tabDesktopPane2.getComponentCount() <= 0) {
                JOptionPane.showConfirmDialog(getParent(), "Sorry, there are no JInternalFrames anymore displayed on this Desktop!");
            } else {
                tabDesktopPane2.remove(tabDesktopPane2.getComponentCount()-1);
                tabbedPane.setSelectedComponent(tabDesktopPane2);
                tab1Added = !tab1Added;
            }
        }
    }
}