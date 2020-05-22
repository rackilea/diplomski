public class Tile extends JLabel
{
    public Tile(String letter, Color background)
    {
        super(letter);
        setBackground( background );
        setOpaque( false );
    }
}