public class RectangleComponent extends JComponent
{
    int x, y;

    RectangleComponent(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Color c = new Color(1.0F,0.0F,1.0F);
        g.setColor(c);

        g.drawRect(x, y, 50, 50);
    }
}