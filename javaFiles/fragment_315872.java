import javax.swing.*;

public class GetWebPage {
    public static void main(String args[]) throws Exception {
        JEditorPane website = new JEditorPane("http://www.google.com/");
        website.setEditable(false);

        JFrame frame = new JFrame("Google");
        frame.add(new JScrollPane(website));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

}