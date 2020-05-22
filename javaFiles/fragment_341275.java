import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;

public class Main {

    private JFrame frame = new JFrame("Test");
    private JTextPane textPane = new JTextPane();
    private JTextArea textArea = new JTextArea();
    private String str = "It seems that JTextPane and JTextArea are rendering fonts differently. "
            + "It is barely noticeable, but I still want to know why is it there. "
            + "I have set up a SSCCE, but you can't really see it. Best method would "
            + "be to run a program with JTextArea, then change the code to JTextPane "
            + "and run it again. They should overlap in a way when you change from one "
            + "window to the other (with alt+ tab) the difference can be seen. "
            + "Why is that? Is there a way to force the JTextPane to render the "
            + "text the same way as JTextArea does?";
    private javax.swing.Timer timer = null;
    final Font fnt = new Font("Brodway", Font.BOLD, 10);

    public Main() {
        textPane.setBorder(new JTextArea().getBorder());
        textPane.setText(str);
        textArea.setText(str);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new JScrollPane(textPane));
        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
        frame.setSize(400, 400);
        start();
    }

    private void start() {
        timer = new javax.swing.Timer(2250, updateCol());
        timer.setRepeats(false);
        timer.start();
    }

    public Action updateCol() {
        return new AbstractAction("text load action") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    LookAndFeel lnf = UIManager.getLookAndFeel().getClass().newInstance();
                    final FontUIResource res = new FontUIResource(fnt);
                    UIDefaults uiDefaults = lnf.getDefaults();
                    //uiDefaults.put("TextPane.font", res);
                    uiDefaults.put("TextArea.font", res);
                    UIManager.getLookAndFeel().uninitialize();
                    UIManager.setLookAndFeel(lnf);
                } catch (InstantiationException ex) {
                    Logger.getLogger(SystemFontDisplayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(SystemFontDisplayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(SystemFontDisplayer.class.getName()).log(Level.SEVERE, null, ex);
                }
                UIDefaults defaults = UIManager.getDefaults();
                final FontUIResource res = new FontUIResource(fnt);
                //defaults.put("TextPane.font", res);
                defaults.put("TextArea.font", res);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        };
    }

    public static void main(String[] args) {
        final FontUIResource res = new FontUIResource(new Font("Algerian", Font.BOLD, 10));
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                    UIDefaults defaults = UIManager.getDefaults();
                    defaults.put("TextPane.font", res);
                    defaults.put("TextArea.font", res);
                } catch (ClassNotFoundException | InstantiationException |
                        IllegalAccessException | UnsupportedLookAndFeelException e) {
                    System.out.println("No Nimbus!");
                }
                break;
            }
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}