SwingUtilities.invokeLater(new Runnable()
{
    public void run()
    {
        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        vertical.setValue( vertical.getMaximum() );
    }
});