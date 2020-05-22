final int SCROLL_BUFFER_SIZE = 100;
public void trunkTextArea(JTextArea txtWin)
{
    int numLinesToTrunk = txtWin.getLineCount() - SCROLL_BUFFER_SIZE;
    if(numLinesToTrunk > 0)
    {
        try
        {
            int posOfLastLineToTrunk = txtWin.getLineEndOffset(numLinesToTrunk - 1);
            txtWin.replaceRange("",0,posOfLastLineToTrunk);
        }
        catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
}