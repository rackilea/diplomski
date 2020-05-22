@Override
public void setActivePage(IEditorPart part)
{
    // ...skipped...

    IActionBars actionBars = getActionBars();
    if (actionBars != null)
    {

        // ...skipped...

        IToolBarManager toolBarManager = actionBars.getToolBarManager();
        if (part instanceof StructuredTextEditor)
        {
            toolBarManager.add(separator);
            toolBarManager.add(updateTabsAction);
        }
        else
        {
            toolBarManager.removeAll();
        }

        toolBarManager.update(true);  //This is important. Otherwise the
                                      //changes aren't applied to the toolbar.
        actionBars.updateActionBars();
    }
}