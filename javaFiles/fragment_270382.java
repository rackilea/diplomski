// You really shouldn't be doing this, mixing heavy and light weight components is
// simply asking for trouble.
//public class MyCanvas extends Canvas 
public class MyCanvas extends JPanel
{
    private Elevator e;

    int xPos =0;
    int yPos=0;

    public MyCanvas()
    {
       // Don't do this, the layout manager will overwrite the values
       //setSize(600,600);
       // Don't do this, it doesn't actually do anything as you ain't in
       // in position to paint yet...
       //repaint();
    }

    // Do this instead...
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }


    public void paint(Graphics g)
    {
        // You MUST do this...
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(xPos,yPos,100, 100);
    }

    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }

    public void setElevator(Elevator ev)
    {
        e = ev;
    }
}