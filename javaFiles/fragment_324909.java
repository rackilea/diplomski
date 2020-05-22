mDocListTable.getSelectionModel().addListSelectionListener(new ListSelectionListener()
{
    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        if(e.getValueIsAdjusting()） return;
        handle_TableSelection(e);
    }
});