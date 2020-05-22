protected void processTextPosition(TextPosition text)
{
    if (text.isDiacritic())
    {
        lastDia = text;
    }
    else if (!text.getUnicode().trim().isEmpty())
    {
        [...process character...]
    } else {
//!! process white spaces here
        //finish current box (if any)
        if (lastText != null)
        {
            finishBox();
        }
        //start a new box
        curstyle = new BoxStyle(style);
        lastText = null;
    }
}