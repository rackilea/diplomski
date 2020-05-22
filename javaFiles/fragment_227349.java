public class Button extends JPanel {
    private JButton button;
    private Panel panel;
    public Button(Panel panel) { // we need already created instance of panel here.
        this.panel = panel;
        button = new JButton("BUTTON");
        // panel = new Panel(); <-- this line must be deleted.
        // ...
    }
}
public class Java extends JFrame {
    private Button dugme;
    private JFrame frame;
    private Panel panel;
    public Java(){
        frame = new JFrame();
        panel = new Panel();
        dugme = new Button(panel);
        // ...
    }
}