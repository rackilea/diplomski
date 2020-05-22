public class CustomHorizontalField extends HorizontalFieldManager{

public boolean enableMoving = false;
private int focusOnIndex = 0;   

public void focusChangeNotify(int arg0) {

    super.focusChangeNotify(arg0);

    if(enableMoving)
    {
        int newFocusIndex = getFieldWithFocusIndex();
        if(newFocusIndex != focusOnIndex)
        {
            if( (newFocusIndex - focusOnIndex )> 0 )
            {
                startRotation(0, getFieldCount()-1);        
            }else
            {
                startRotation(getFieldCount()-1, 0);
            }
        }

    }else
    {
        focusOnIndex = getFieldWithFocusIndex();
    }

}
public int getPreferredWidth() {
    return Display.getWidth();
}
public int getPreferredHeight() {
    return super.getPreferredHeight();
}
protected void sublayout(int maxWidth, int maxHeight) {
    super.sublayout(Display.getWidth(), getPreferredHeight());
    setExtent(Display.getWidth(), getPreferredHeight());
}

private void startRotation(int from,int to)
{
    Field field = getField(from);
    delete(field);
    insert(field, to);
}   
}