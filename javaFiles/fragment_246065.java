import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.accessibility.AccessibleText;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelMouseDemo {
    private static String labelText = "<html>C:\\aaa\\bbb\\ccc</html>";
    private static JLabel label;
    private static JLabel substringDisplayLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        label = new JLabel(labelText);
        label.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                AccessibleText accessibleText =
                        label.getAccessibleContext().getAccessibleText();
                Point p = e.getPoint();
                int index = accessibleText.getIndexAtPoint(p);
                if (index >= 0) {
                    // The index is with respect to the actually displayed
                    // characters rather than the entire HTML string, so we
                    // must add six to skip over "<html>", which is part of
                    // the labelText String but not actually displayed on
                    // the screen. Otherwise, the substrings could end up
                    // something like "tml>C:\aaa"
                    index += 6;

                    // Strangely, in my testing, index was a one-based index
                    // (for example, mousing over the 'C' resulted in an
                    // index of 1), but this makes getting the part of the
                    // string up to that character easier.
                    String partOfText = labelText.substring(0, index);

                    // Display for demonstration purposes; you could also
                    // figure out how to highlight it or use the string or
                    // just the index in some other way to suit your needs.
                    // For example, you might want to round the index to
                    // certain values so you will line up with groups of
                    // characters, only ever having things like
                    // "C:\aaa\bbb", and never "C:\aaa\b"
                    substringDisplayLabel.setText(partOfText);
                }
            }
        });
        frame.add(label);
        substringDisplayLabel = new JLabel();
        frame.add(substringDisplayLabel, BorderLayout.SOUTH);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}