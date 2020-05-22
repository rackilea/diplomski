public class ExtraFunctionalActivity extends Activity
{
    public void read(...)
    {        
        //your code
    }
}

public class GeneralSetupUtility extends ExtraFunctionalActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gettingstarted_layout);

        read(this,"gettingstarted/GettingStarted.txt", R.id.displayTextView);

    }
}