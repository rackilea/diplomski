class TheClass extends JComponent
{
    private boolean paintTheFirstThing = true;

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        if (paintTheFirstThing)
        {
            g.setColor(Color.BLUE);
            g.drawRect(50, 50, 50, 50);
            g.drawOval(60, 60, 60, 60);
        }
        else
        {
            g.drawOval(10, 10, 10, 10)  
        }
    }

    void setPaintTheFirstThing(boolean p)
    {
        this.paintTheFirstThing = p;
        repaint();
    }
}