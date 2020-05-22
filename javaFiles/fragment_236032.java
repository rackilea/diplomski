// Replace JOptionPane.showXxxx(args) with new JOptionPane(args)
JOptionPane pane = new JOptionPane(...);
final JDialog dialog = pane.createDialog("title");
Timer timer = new Timer(DELAY, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
        // or maybe you'll need dialog.dispose() instead?
    }
});
timer.setRepeats(false);
timer.start();
dialog.setVisible(true);