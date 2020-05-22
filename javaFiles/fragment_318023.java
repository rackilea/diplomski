public class TestJEditorPane {
public static void main(String[] args) {
    JFrame frame = new JFrame();

    JEditorPane pane = new JEditorPane();
    pane.setContentType("text/html");
    pane.setText("<html><b>Hello World</b></html>");

    frame.add(pane);
    frame.setSize(200, 200);
    frame.setVisible(true);
}
}