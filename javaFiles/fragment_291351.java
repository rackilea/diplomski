public class SampleComponent extends JLabel
{
    @Override
    protected void paintComponent ( final Graphics g )
    {
        final Graphics2D g2d = ( Graphics2D ) g;

        final Image image = ...; // Your image
        g2d.drawImage (
                image,
                dstX1, dstY1, dstX2, dstY2,
                imgX1, imgY1, imgX2, imgY2,
                null
        );

        super.paintComponent ( g );
    }
}