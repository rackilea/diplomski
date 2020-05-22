import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShowMessageDialogExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        String css = "<span style='font-size: 10; color: white; background-color: black'>";
        String batchCss = "<span style='font-size: 20;'>";
        String endSpanCss = "</span>";
        JOptionPane.showMessageDialog(frame, "<html>" + css + batchCss + " 1 " + endSpanCss + "of" + batchCss + " 2 " + endSpanCss + endSpanCss + "</html>");
        System.exit(0);
    }
}