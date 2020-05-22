public class Lamp
{
    protected Color kleur = Color.YELLOW;
    /// Other things...

    public void teken(Graphics g)
    {
            Graphics2D g2 = (Graphics2D) g;

            // Draw the lamp parts

            if(aanUit == true)
            {
                g.setColor(this.kleur); // Set color here
            }
            else
            {
                g.setColor(Color.WHITE);
            }
            g.fillOval(208, 100, 50, 50);
            g.setColor(Color.BLACK);
    }

}