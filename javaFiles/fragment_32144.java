if( UIManager.getBoolean( "PopupMenu.consumeEventOnClose" ) )
{
    popupButton.setSelected( false );
}
else
{
    Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
    Point componentLoc = popupButton.getLocationOnScreen();
    mouseLoc.x -= componentLoc.x;
    mouseLoc.y -= componentLoc.y;
    if( !popupButton.contains( mouseLoc ) )
    {
        popupButton.setSelected( false );
    }
}