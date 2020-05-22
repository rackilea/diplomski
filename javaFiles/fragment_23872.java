import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.net.URL;
import java.io.*;

public class TestRammettoFont {

    private JComponent ui = null;
    String fontAddress = "jar:http://dl.1001fonts.com/rammetto-one.zip"
            + "!/RammettoOne-Regular.ttf";

    TestRammettoFont() {
        try {
            initUI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public final void initUI() throws Exception {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(14, 14, 14, 14));

        URL url = new URL(fontAddress);
        InputStream is = url.openStream();
        Font font = Font.createFont(Font.TRUETYPE_FONT, is);

        font = font.deriveFont(Font.PLAIN, 25);
        JLabel l = new JLabel("The quick brown fox (etc.)");
        l.setFont(font);
        ui.add(l);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                TestRammettoFont o = new TestRammettoFont();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}