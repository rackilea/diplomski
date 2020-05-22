public class MainActivity implements AsyncTaskListener
{
    public void onCreate(Bundle savedInstanceState)
    {
        super(savedInstanceState);
        setContentView(R.layout.main_activity);

        //Your stuff

        new ZipHelper(zip[0].mZipFileName, file, MainActivity.this).execute();
    }

    public void onTaskComplete()
    {
        //AsyncTask post stuff
    }
}