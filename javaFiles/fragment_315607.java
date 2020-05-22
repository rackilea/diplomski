public class CardInfo extends ViewPart implements ISelectionListener, ICardHistoryDelegate, 
    IPinViewDelegate, IToggleSearchBarDelegate, ICardSearchListener  {

... other methods snipped

public void createPartControl (Composite parent)  {
    ... rest of method that actually creates the view components snipped

    //  Hook up to listen to selection changes
    getSite ().getWorkbenchWindow ().getSelectionService ().addSelectionListener (this);
}

public void selectionChanged (IWorkbenchPart part, ISelection selection)  {

    if (selection.isEmpty()  ||  !(selection instanceof IStructuredSelection))  {
        //  Do not clear the view even for empty selections or selections of another 
        //  type - just do nothing.  That way the last card looked at will be visible no 
        //  matter what else happens
        return;
    }

    //  Display the first selected element
    IStructuredSelection structuredSel = (IStructuredSelection)selection;
    Object firstSelectedObject = structuredSel.getFirstElement ();

    //  Get the ICard interface from the selection - using its IAdaptable interface
    if (firstSelectedObject == null  ||  !(firstSelectedObject instanceof IAdaptable))
        return; // no work to do
    ICard selectedCard = (ICard)((IAdaptable)firstSelectedObject).getAdapter(ICard.class);
    if (selectedCard == null)
        return; // no work to do

... rest of method that actually does something with new selection snipped