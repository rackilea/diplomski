// Why are you using a `MouseListener` on buttons??
// User use keyboards to, use an ActionListener instead
public void mouseClicked(MouseEvent e) {
    setDisposeState(CANCEL);
    dialog.dispose();
    System.out.println("Reg disposed by cancel button");
}