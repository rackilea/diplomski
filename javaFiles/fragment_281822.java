class Paint extends Canvas
{
    Mouse mouse;

    public Paint(Mouse mouse)
    {
        this.mouse = mouse;
    }

    @Override
    public void paint(Graphics g)
    {
        g.drawRect(mouse.getX(), mouse.getY(), 10, 10);
    }
}