JFrame f = new JFrame("Example");
Action accept = new AbstractAction("Accept") {

    @Override
    public void actionPerformed(ActionEvent e) {
        // handle accept
    }
};
private JButton b = new JButton(accept);
...
f.getRootPane().setDefaultButton(b);