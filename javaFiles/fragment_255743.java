public JScrollPane buildScrollingContainerPanel()
{
    JPanel containerPanel = new JPanel(new GridLayout(0, 1));
    JScrollPane scrollPane = new JScrollPane(containerPanel);
    containerPanel.add(new MyPanel(true, false));
    containerPanel.add(new MyPanel(false, true));

    return (scrollPane);
}

private class MyPanel extends JPanel
{
    private boolean drawRect;
    private boolean drawOval;

    public MyPanel(boolean drawRect, boolean drawOval)
    {
        super();
        this.drawRect = drawRect;
        this.drawOval = drawOval;
    }

    public void setDrawRect(boolean b)
    {
        drawRect = b;
        repaint();
    }

    public void setDrawOval(boolean b)
    {
        drawOval = b;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if (drawOval)
        {
            g.setColor(Color.RED);
            g.drawOval(16, 16, 16, 16);
        }

        if (drawRect)
        {
            g.setColor(Color.GREEN);
            g.drawRect(32, 32, 16, 16);
        }
    }
}