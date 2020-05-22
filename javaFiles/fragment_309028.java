private boolean isBound = false;

private static int bindCount = 0;

// handles the service connection.
protected static ServiceConnection connection = new ServiceConnection(){
// ...
}

@Override
public void onResume()
{
    super.onResume();
    //bind the activity to the service when it is not bound yet.
    if (!this.isBound)
    {
        if (bindCount == 0) {
            //Application context, because the Connection shall be kept over configuration change, and the activity will be replaced then.
            Intent serviceIntent = new Intent(this.getApplicationContext(), ConnectionService.class);
            bindService(serviceIntent, DatapointActivity.connection, Context.BIND_AUTO_CREATE);
            this.isBound = true;
        }
        bindCount++;
        this.isBound = true;
    }
    this.visible = true;
}

/**
 * Saves the bound state.
 */
@Override
public void onSaveInstanceState(Bundle outState)
{
    outState.putBoolean("isBound", this.isBound);
}

/**
 * Loads the bound state.
 */
@Override
public void onRestoreInstanceState(Bundle inState)
{
    this.isBound = inState.getBoolean("isBound");
}

@Override
public void onPause()
{
    //unbind the activity of the service when it is finishing.
    super.onPause();
    this.visible = false;
    if (this.isFinishing())
    {
        if(bindCount <= 1 && this.isBound )
        {
            unbindService(DatapointActivity.connection);                
        }
        bindCount--;
    }

}