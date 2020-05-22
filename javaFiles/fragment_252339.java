SwingUtilities.invokeLater(new Runnable()
{
    public void run()
    {
        scrollPane.getViewport().setViewPosition( new Point(0, 0) );
    }
});