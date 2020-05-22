import java.awt.*;
import javax.swing.*;

public class FuSwing1b extends JPanel {
    private static final int TA_ROWS = 25;
    private static final int TA_COLS = 60;
    private JTextField inputField = new JTextField();
    private JTextArea talkArea = new JTextArea(TA_ROWS, TA_COLS);

    public FuSwing1b() {
        talkArea.setEditable(false);
        talkArea.setFocusable(false);
        talkArea.setBackground(Color.white);
        //talkArea.setPreferredSize(new Dimension(TALK_WIDTH, TALK_HEIGHT));

        JScrollPane talkPane = new JScrollPane(talkArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane inputPane = new JScrollPane(inputField, JScrollPane.VERTICAL_SCROLLBAR_NEVER, 
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        int gap = 10;
        setLayout(new BorderLayout(gap, gap));
        add(talkPane, BorderLayout.CENTER);
        add(inputPane, BorderLayout.SOUTH);
        setBorder(BorderFactory.createEmptyBorder(gap , gap, gap, gap));
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("FuSwing1b");
        frame.getContentPane().add(new FuSwing1b());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}