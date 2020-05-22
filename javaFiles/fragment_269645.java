JPanel panel = new JPanel()
{
    protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
};
panel.setOpaque(false);
panel.setBackground( new Color(255, 0, 0, 20) );
frame.add(panel);