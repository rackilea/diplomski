fragment.getView().setFocusableInTouchMode(true); //Don't miss this line
fragment.getView().setOnKeyListener( new OnKeyListener()
{
    @Override
    public boolean onKey( View v, int keyCode, KeyEvent event )
    {
        if( keyCode == KeyEvent.KEYCODE_BACK )
        {
           //Do what you want
            return true;
        }
        return false;
    }
} );