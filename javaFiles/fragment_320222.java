public static void main(String args[]) throws Exception {
JWindow jWindow = new JWindow() {
final Icon icon = new ImageIcon(<yourImage>);  // Okay to be animated
{
    setOpacity(.642f);
    setLocation(0,0);
    setSize(icon.getIconWidth(), icon.getIconHeight());
    add(new JLabel(icon));
    pack();
}
};
jWindow.setVisible(true);
Thread.sleep(3000);
jWindow.setVisible(false);
}