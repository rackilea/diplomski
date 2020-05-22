public class MyPanel extend JPanel
{
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent( g );

        //  add custom painting code
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(...);
    }
}