JTextArea area1 = new JTextArea()
{
    public Dimension getMaximumSize()
    {
        Dimension d = super.getMaximumSize();
        d.height = getPreferredSize().height;

        return d;
    }
};