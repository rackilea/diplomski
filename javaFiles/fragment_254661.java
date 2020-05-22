import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;

@SuppressWarnings("serial")
public class TabbedPaneTest extends JTabbedPane {

    public static void main(String[] args) {

        JFrame frame = new JFrame("TabbedPane");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.RED);
        frame.getContentPane().add(new TabbedPaneTest());
        frame.setVisible(true);
    }

    public TabbedPaneTest() {

        UIManager.put("TabbedPane.contentBorderInsets", new InsetsUIResource(1, 0, 0, 0));
        UIManager.put("TabbedPane.contentAreaColor", new ColorUIResource(Color.GREEN));
        UIManager.put("TabbedPane.focus", new ColorUIResource(Color.ORANGE));
        UIManager.put("TabbedPane.selected", new ColorUIResource(Color.YELLOW));
        UIManager.put("TabbedPane.darkShadow", new ColorUIResource(Color.DARK_GRAY));
        UIManager.put("TabbedPane.borderHightlightColor", new ColorUIResource(Color.LIGHT_GRAY));
        UIManager.put("TabbedPane.light", new ColorUIResource(Color.WHITE));
        UIManager.put("TabbedPane.tabAreaBackground", new ColorUIResource(Color.CYAN));
        UIManager.put("ToolTip.background", Color.WHITE);
        UIManager.put("ToolTip.border", new BorderUIResource(new LineBorder(Color.BLACK)));
        this.updateUI();

        this.setBackground(Color.BLUE);

        JPanel testPanel = new JPanel();
        testPanel.setLayout(new BorderLayout());
        testPanel.add(new JLabel("Hello World"), BorderLayout.NORTH);
        testPanel.add(new JTextArea("Looks nice out there :)"), BorderLayout.CENTER);

        JPanel testPanel2 = new JPanel();
        testPanel2.setLayout(new BorderLayout());
        testPanel2.add(new JLabel("Good Bye World"), BorderLayout.NORTH);
        testPanel2.add(new JTextArea("AAAAAnnnnnd... I'm gone"), BorderLayout.CENTER);

        this.addTab("Hello World", testPanel);
        this.addTab("BB World", testPanel2);
    }
}