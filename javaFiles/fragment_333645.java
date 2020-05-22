class Game extends JDialog {
    public Game(JFrame frame, boolean modal) {
        super(frame, modal);
        setLayout(new BorderLayout());
        add(new Player());

        pack();
        setVisible(true);
    }
}