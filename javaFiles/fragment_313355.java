@Override
public boolean onContextItemSelected(MenuItem item) {

    if( ! getUserVisibleHint() )
    {
        return false;
    }

// I get the text
    mCopyText =  getText();