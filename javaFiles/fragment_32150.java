@Override
public boolean onKeyUp( int keyCode, KeyEvent event )
{
    if( keyCode == KeyEvent.KEYCODE_BACK )
    {
        goBack();
        return true;
    }
    return super.onKeyUp( keyCode, event );
}