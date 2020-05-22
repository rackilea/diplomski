public class BackgroundTask extends AsyncTask<String,Void,String>
{        
    private ValueListener listener;

    BackgroundTask(ValueListener listener)
    {
        this.listener= listener;
    }
}