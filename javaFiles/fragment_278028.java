TransferHandler iconHandler = new TransferHandler( "icon" )
{
    Component target;

    @Override
    public int getSourceActions(JComponent c)
    {
        return MOVE;
    }

    @Override
    public boolean importData(TransferSupport info)
    {
        target = info.getComponent();

        return super.importData( info );
    }

    @Override
    protected void exportDone(JComponent source, Transferable data, int action)
    {
        if (action == MOVE
        &&  source != target)
        {
            ((JLabel)source).setIcon(null);
        }
    }
};