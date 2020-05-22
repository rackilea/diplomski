splitPane.addPropertyChangeListener("dividerLocation", new PropertyChangeListener()
{
    @Override
    public void propertyChange(PropertyChangeEvent e)
    {
        int location = ((Integer)e.getNewValue()).intValue();
        System.out.println(location);

        if (location > 400)
        {
            JSplitPane splitPane = (JSplitPane)e.getSource();
            splitPane.setDividerLocation( 400 );
        }
    }
});