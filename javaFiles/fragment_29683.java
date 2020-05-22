public class PanelA extends JPanel {
    ...
    private final Gui gui;
    PanelA(Gui gui) {
        this.gui = gui;
    }
    ... () {
        setBackground(Color.ORANGE);
        JButton btn = new JButtn("Show Panel B");
        add(btn);
    }

    public void actionPerformed(ActionEvent ae) {
        ...
        gui.cards. ...
    }
}