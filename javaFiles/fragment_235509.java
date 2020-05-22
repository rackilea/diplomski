final Cursor crosshairCursor = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
final Cursor defaultCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);

public void mouseMoved(MouseEvent e)
{
    if(GUI.Connectionbutton.isSelected())
    {
        x = e.getX();
        y = e.getY();

        boolean wasValid = validConnectionRegion;
        checkValidConnectionRegion(); 

        if(wasValid != validConnectionRegion)
            setCursor(validConnectionRegion ? crosshairCursor : defaultCursor);
    }
}