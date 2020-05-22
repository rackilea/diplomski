public static CursorInfo getCursor(String search)
{
    for(CursorInfo cursorValue : CursorInfo.values())
    {
        for(String tool : cursorValue.toolTip)
        {
            if (search.equals(tool))
                return cursorValue;
        }
    }

    //proper error handling
    return null;
}