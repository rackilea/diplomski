TabPanel panel = ...;

SelectionHandler<Integer> handler = new SelectionHandler<Integer>()
{
    @Override
    public void onSelection(SelectionEvent<Integer> event)
    {

    }
};

panel.addSelectionHandler(handler);