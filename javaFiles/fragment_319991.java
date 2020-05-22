JSpinner spinner=new JSpinner()
{
    @Override
    public Dimension getMaximumSize()
    {
        return getPreferredSize();
    }
};