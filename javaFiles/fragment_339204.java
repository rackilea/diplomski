class InnerPanel extends JPanel
{
  public void paint(Graphics g)
  {
     Graphics2D g2 = (Graphics2D)g;
     g2.drawRect(....);
  }
}

class MyLayered extends JLayeredPane()
{
  MyLayered()
  {
    this.add(new InnerPanel(), 14);
  }
}