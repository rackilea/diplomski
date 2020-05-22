public class PanelB extends JPanel {
    ...
    private final Gui gui;
    PanelB(Gui gui) {
        this.gui = gui;
    }
    ...
    ... () {
        setBackground(Color.GREEN);
        JButton btn = new JButtn("Show Panel A");
        add(btn);
    }

    public void actionPerformed(ActionEvent ae) {
        ...
        gui.cards. ...
    }
}