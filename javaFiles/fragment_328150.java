boolean isSilent = false;

public void fieldChanged(Field field, int context) 
{
    if(!isSilent && field == silentSwitch)
    {
        setVolume(0);
        isSilent = true;
    }
    else if(field == silentSwitch && isSilent)
    {
        setVolume(20);
        isSilent = false;           
    }
}