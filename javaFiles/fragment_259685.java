public class app extends Applet {

    public void init() {
        JMenuBar menuBar = new JMenuBar ();
        JMenu menu = new JMenu ("Help");
        menuBar.add(menu);
        JMenuItem   mItem = new JMenuItem ("Log out");
        menu.add(mItem);
        this.setJMenuBar(menuBar);