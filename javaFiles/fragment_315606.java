public class DeckSlotTreeEditPart extends AbstractTreeEditPart implements PropertyChangeListener  {

... other code snipped

public void activate ()  {
    if (!isActive ()) {
        super.activate ();
        getDeckSlot ().addPropertyChangeListener (this);
    }
}


@Override
public void deactivate ()  {
    if (isActive ()) {
        super.deactivate ();
        getDeckSlot ().removePropertyChangeListener (this);
    }
}


public void propertyChange (PropertyChangeEvent evt)  {
    refreshVisuals ();
}


protected DeckSlot getDeckSlot ()  {
    return (DeckSlot)getModel ();
}