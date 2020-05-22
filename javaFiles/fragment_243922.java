@Override
public void paintComponent(Graphics g) 
{
    super.paintComponent(g); //super.paintComponents(g);
    setBackground(Color.BLACK);
    g.setColor(Color.RED);
    g.drawLine(100, 50, 150, 100);
}