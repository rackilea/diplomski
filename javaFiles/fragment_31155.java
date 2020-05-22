SwingUtilities.invokeLater(new Runnable()
    {
    public void run()
    {
    detailpane.scrollPane.getVerticalScrollBar().setValue(spoint);
    }
    });