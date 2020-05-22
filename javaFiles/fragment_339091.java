marquee.addMouseListener( new MouseAdapter()
{
    @Override
    public void mousePressed(MouseEvent e)
    {
        Component c = marquee.getComponentAt(e.getPoint());

        if (c == null) return;

        if (c insstanceof JLabel)
        {
            JLabel label = (JLabel)c;
            System.out.println(label.getText());
        }
    }
});