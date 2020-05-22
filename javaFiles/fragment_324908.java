ListSelectionListener listener = new ListSelectionListener()
{
    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        handle_TableSelection(e);
    }
};

mDocListTable.getSelectionModel().removeListSelectionListener(listener);    
for (int i = 0; i < sArray.length; i++)
{
    mTableForActionListener.addRowSelectionInterval(sArray[i].intValue(), sArray[i].intValue());
}
mDocListTable.getSelectionModel().addListSelectionListener(listener);
// add some code here to deal with the new selections in the table.