@Override
public boolean dispatchKeyEvent(KeyEvent ke)
{

    int unicode = ke.getUnicodeChar();
    if (ke.getAction() == 0 && ke.getKeyCode() == KeyEvent.KEYCODE_ENTER) // getAction() returns 1 (up) or 0 (down). 
    {
        // do my work here
        return true; // end here (doesn't go to onKeyDown())
    } else
    return super.dispatchKeyEvent(ke);
}