class mydraw extends JPanel
{

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.green);
        g.fillOval(x, y, 40, 40);
    }
}