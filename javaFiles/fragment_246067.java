import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.accessibility.AccessibleText;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelMouseHighlightDemo {
    private static String rawText = "C:\\aaa\\bbb\\ccc";
    private static JLabel label;

    private static String formatLabelText(int index) {
        if (index < 0) {
            index = 0;
        }
        if (index > rawText.length()) {
            index = rawText.length();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<font color='red'>");
        sb.append(rawText.substring(0, index));
        sb.append("</font>");
        sb.append(rawText.substring(index));
        sb.append("</html>");
        return sb.toString();
    }

    private static int roundIndex(int index) {
        // This method rounds up index to always align with a group of
        // characters delimited by a backslash, so the red text will be
        // "C:\aaa\bbb" instead of just "C:\aaa\b".
        while (index < rawText.length() && rawText.charAt(index) != '\\') {
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        label = new JLabel(formatLabelText(0));
        label.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                AccessibleText accessibleText =
                        label.getAccessibleContext().getAccessibleText();
                Point p = e.getPoint();
                int index = accessibleText.getIndexAtPoint(p);
                index = roundIndex(index);
                label.setText(formatLabelText(index));
            }
        });
        frame.add(label);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}