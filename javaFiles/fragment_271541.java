import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class GradientTextAreaTest extends JPanel {
    public static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt "
            + "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut "
            + "aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu "
            + "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit "
            + "anim id est laborum.";
    public static final int FILLER = 130;
    public static final Color C1 = new Color(255, FILLER, FILLER);
    public static final Color C2 = new Color(FILLER, FILLER, 255);
    private JTextArea textArea = new JTextArea(14, 30);

    // create the view port with colors passed into it
    private GradientViewport viewport = new GradientViewport(C1, C2);
    private JScrollPane scrollPane = new JScrollPane();

    public GradientTextAreaTest() {
        setLayout(new BorderLayout());
        textArea.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        for (int i = 0; i < 10; i++) {
            textArea.append(TEXT + "\n");
        }

        // make the JTextArea transparent
        textArea.setOpaque(false);

        // set the viewport's view with your JTextArea
        viewport.setView(textArea);

        // set the JScrollPane's viewport with our viewport object
        scrollPane.setViewport(viewport);

        // add the JScrollPane to our GUI
        add(scrollPane);
    }

    private static void createAndShowGui() {
        GradientTextAreaTest mainPanel = new GradientTextAreaTest();

        JFrame frame = new JFrame("GradientTextAreaTest");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

}