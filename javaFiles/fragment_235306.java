import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class TestLineBreak {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append("Text goes here <br>"); //<br> tag to insert line breaks
        }
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextPane newsTextPane = new JTextPane();
        newsTextPane.setContentType("text/html");
        newsTextPane.setEditable(false);
        newsTextPane.setText(sb.toString());

        JScrollPane scrollPane = new JScrollPane(newsTextPane);
        frame.add(scrollPane);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}