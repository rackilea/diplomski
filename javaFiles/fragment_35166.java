// Why are you using a `MouseListener` on buttons??
// User use keyboards to, use an ActionListener instead
public void mouseClicked(MouseEvent e) {
    Reg new1=new Reg(users);
    new1.setVisible(true);
    switch (new1.getDisposeState()) {
        case Reg.OK:
            // Clicked Ok
            break;
        case Reg.CANCEL:
            // Clicked cancel or was closed by press [x]
            break;
    }
}