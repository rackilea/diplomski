@Override
public boolean onContextItemSelected(MenuItem item) {

    if( ! getUserVisibleHint() )
    {
        return false;
    }

// this is not working
text = tvTextView.getText().toString();