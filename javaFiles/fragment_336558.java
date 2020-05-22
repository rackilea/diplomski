@Override
protected void paintComponent(Graphics g)
{
    Graphics2D g2 = (Graphics2D) g;
    g2.rotate(angle, getPreferredSize().width/2, getPreferredSize().height/2);
    g2.drawString(super.getText(), 0, 0);  // ****** here *****
    setBounds(getX(), getY());
    super.paintComponent(g);             // ******* here ******
}