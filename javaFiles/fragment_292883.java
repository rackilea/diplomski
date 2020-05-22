@Override
public void mousePressed(MouseEvent mEvt) {
   JLabel label = (JLabel) mEvt.getSource();
   Icon icon = label.getIcon();
   JOptionPane.showMessageDialog(label, icon);
}