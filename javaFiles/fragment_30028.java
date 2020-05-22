import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BackgroundImageInHTML {

    // the GUI as seen by the user (without frame)
    private JPanel gui;
    private final static String HTML = "<html>"
            + "<head>"
            + "<style type=text/css>"
            + "body {"
            + "  background-image: http://i.stack.imgur.com/IHARa.png;"
            + "  background-repeat:no-repeat;"
            + "  background-position:left top;"
            + "  background-attachment: scroll;"
            + "  color: #BBBBBB;"
            + "}"
            + "</style>"
            + "</head>"
            + "<body>"
            + "<h1>Heading 1</h1>";
    private final String PARAGRAPH = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eu nulla urna. Donec sit amet risus nisl, a porta enim. Quisque luctus, ligula eu scelerisque gravida, tellus quam vestibulum urna, ut aliquet sapien purus sed erat. Pellentesque consequat vehicula magna, eu aliquam magna interdum porttitor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed sollicitudin sapien non leo tempus lobortis. Morbi semper auctor ipsum, a semper quam elementum a. Aliquam eget sem metus.";

    BackgroundImageInHTML() {
        initializGui();
    }

    public void initializGui() {
        gui = new JPanel(new BorderLayout());
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        // TODO - not ideal
        gui.setPreferredSize(new Dimension(400, 100));

        StringBuilder sb = new StringBuilder();
        sb.append(HTML);
        for (int ii = 0; ii < 10; ii++) {
            sb.append("<h2>Header 2</h2>");
            sb.append(PARAGRAPH);
        }
        JEditorPane jep = new JEditorPane();
        jep.setOpaque(false);
        jep.setContentType("text/html");
        jep.setText(sb.toString());
        JScrollPane jsp = new JScrollPane(jep) {
            BufferedImage bg = new BufferedImage(350,50,BufferedImage.TYPE_INT_RGB);
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, this);
            }
        };
        jsp.getViewport().setOpaque(false);
        gui.add(jsp);
    }

    public JComponent getGui() {
        return gui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {

                BackgroundImageInHTML bih = new BackgroundImageInHTML();

                JFrame f = new JFrame("Demo");
                f.add(bih.getGui());
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}