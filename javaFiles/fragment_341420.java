JMenuItem menuItem = new JMenuItem(new MyAction());
...
public class MyAction extends AbstractAction {
    public MyAction() {
        super("My Menu Item");
    }

    public void actionPerformed(ActionEvent e) {
        // Button pressed logic goes here
    }
}