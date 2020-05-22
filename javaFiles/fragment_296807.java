CCombo combo = (CCombo) cellEditor.getControl();

combo.addSelectionListener(new SelectionListener()
{

    @Override
    public void widgetSelected(SelectionEvent paramSelectionEvent)
    {
        //selection code here...
    }

    @Override
    public void
        widgetDefaultSelected(SelectionEvent paramSelectionEvent)
    {
        //do nothing here...
    }
});