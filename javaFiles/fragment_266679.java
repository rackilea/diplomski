public class Mewindow extends JFrame {

    private JLabel mepic
    public Mewindow() {

        super("Here is a picture of ME!");

        setLayout(new GridLayout(1, 0, 0, 0));

        mepic = new JLabel(new ImageIcon(getClass().getResource("me.png")));
        add(mepic);

        setVisible(true);
        setSize(250, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}