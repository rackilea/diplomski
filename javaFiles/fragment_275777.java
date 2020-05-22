public class TestFrame extends JFrame {

    private ActionManager actionManager

    private JMenuBar mb;
    private JMenu file;
    private JMenuItem openDialog1;
    private JMenuItem openDialog2;

    public TestFrame() {

        this.actionManager = new ActionManager();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPanel(panel);
        setJMenuBar(createMenuBar());
        pack();
    }

    private JMenuBar createMenuBar() {
        mb = new JMenuBar();
        file = new JMenu("File");
        openDialog2 = new JMenuItem("Open Dialog 2");
        openDialog1 = new JMenuItem("Open Dialog 1");
        openDialog2.addActionListener(actionManager.openDialog2Action);
        openDialog1.addActionListener(actionManager.openDialog1Action);

        //here i would add conditional code that added the correct
        //menus to the menubar and menuitems to the correct menus and call
        //this method from a `ChangeListener` that listens for tab changes so
        //it recreates a new menu with the correct components for the selected
        //tab but i added them to the same menu to demonstrate using specific actions
        //for each menu item, it doesn't matter which menu they're attached to their
        //action wont be called unless that JMenuItem is clicked. 
        //this method can be used for any type of button as well, commonly with
        //toolbars, so you can reuse actions like copy, paste, new, open, save, etc

        file.add(openDialog1);
        file.add(openDialog1);
        mb.add(file);

        return mb;
    }

    public static void main(String[] args) {
        TestFrame frame = new TestFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}