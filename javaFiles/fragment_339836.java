JOptionPane pane = new JOptionPane("Are you hungry?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);

JDialog dialog = pane.createDialog("Title");
dialog.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent evt) {
    }
});
dialog.setContentPane(pane);
dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
dialog.pack();

dialog.setVisible(true);
int c = ((Integer)pane.getValue()).intValue();

if(c == JOptionPane.YES_OPTION) {
  JOptionPane.showMessageDialog(null, "eat!", "Order",JOptionPane.PLAIN_MESSAGE);
}
else if (c == JOptionPane.NO_OPTION) {
  JOptionPane.showMessageDialog(null, "ok cool", "Order",JOptionPane.PLAIN_MESSAGE);
}