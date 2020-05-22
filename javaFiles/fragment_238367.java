@Override
class PaintExtension extends JComponent
{
    public void paintComponent(Graphics g)
    {
       int vidas = GetVidas(); //Make a method to get the vidas
       super.paintComponent(g);
       if(vidas == 6)
       {
          g.drawOval(10, 10, 30, 30);
       } 
       else
       {
          g.drawOval(10, 10, 60, 60);
       }

    }
}