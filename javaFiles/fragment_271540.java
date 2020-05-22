import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class GradientTextAreaTest extends JPanel {
    public static final Color C1 = new Color(255, 200, 200);
    public static final Color C2 = new Color(200, 200, 255);
    private JTextArea textArea = new JTextArea(30, 40);

    // create the view port with colors passed into it
    private GradientViewport viewport = new GradientViewport(C1, C2);
    private JScrollPane scrollPane = new JScrollPane();

    public GradientTextAreaTest() {
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

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