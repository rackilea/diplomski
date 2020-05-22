public class EntityPainter implements Painter
{

    @Override
    public void paint( Graphics2D g, Object thePanel, int width, int height )
    {
        g.drawImage(player.getImage(), player.getX(), player.getY(), null);
    }

}