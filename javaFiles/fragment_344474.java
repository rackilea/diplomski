protected void processTextPosition(TextPosition text)
{
    if (text.isDiacritic())
    {
        lastDia = text;
    }
    else if (!text.getUnicode().trim().isEmpty())
    {
        [...process character...]
    }
}