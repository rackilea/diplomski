htmlPane = new JEditorPane()
{
    @Override
    public Dimension getMinimumSize()
    {
        Dimension d = super.getMinimumSize();
        d.width = 100;

        return d;
    }
};