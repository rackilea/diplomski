import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MinFrame extends JFrame {

    public MinFrame() {
        super("Minimal-Frame-Application");

        // setup menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menu.setMnemonic('F');
        JMenuItem menuItem = new JMenuItem("Exit");
        menuItem.setMnemonic('x');
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_MASK));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        menu.add(menuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // setup widgets
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
        JScrollPane westPanel = new JScrollPane(new JTree());
        JEditorPane editor = new JEditorPane("text/plain", "Hello World");
        JScrollPane eastPanel = new JScrollPane(editor);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, westPanel,eastPanel);
        splitPane.setDividerLocation(148);
        contentPanel.add(splitPane, BorderLayout.CENTER);


        AbstractButton winLF = new JButton("Windows");
        winLF.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MinFrame.this.dispose();
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    SwingUtilities.updateComponentTreeUI(MinFrame.this.getRootPane());

                    MinFrame.this.setUndecorated(false);
                    MinFrame.this.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        AbstractButton customLF = new JButton("JTatto");
        customLF.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MinFrame.this.dispose();
                    UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                    MinFrame.this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
                    SwingUtilities.updateComponentTreeUI(MinFrame.this.getRootPane());

                    MinFrame.this.setUndecorated(true);
                    MinFrame.this.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JPanel buttons = new JPanel();
        buttons.add(winLF);
        buttons.add(customLF);
        contentPanel.add(buttons, BorderLayout.SOUTH);
        setContentPane(contentPanel);

        // add listeners
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // show application
        setLocation(32, 32);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    } // end CTor MinFrame

    public static void main(String[] args) {
        try {
            // select Look and Feel
//            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            // start application
            new MinFrame();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    } // end main

}