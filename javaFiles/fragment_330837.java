public class ActivityB extends Activity
{
    private T1 t1;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        t1 = startMyThread();
    }

    @Override
    public void onBackPressed()
    {
        ActivityA.tempT1 = t1;

        //This technique presumes that Activity A is guaranteed to resume after a 
        //back button press, based on the arrangement of your backstack, etc. If
        //Activity A is started via some other means (e.g., an explicit startActivity(),
        //finish(), etc.), then this reference will have to be set prior to
        //that call, as well, in order to establish the appropriate "happens before" relationship.
        //If you fail to ensure that Activity A resumes after this point, you will
        //risk a memory leak.

        super.onBackPressed();
    }
}

public class ActivityA extends Activity
{
    public static T1 tempT1 = null;
    private T1 t1;

    @Override
    public void onResume()
    {
        super.onResume();
        if(tempT1 == null)
        {
            //Apparently, Activity B hasn't executed yet. Provide the user with a button to start it.
        }
        else
        {
            t1 = tempT1;
            tempT1 = null;     //To avoid a memory leak

            //We just retrieved the reference that Activity B left for us.
            //Now, change UI states so that the user can see information about t1.
        }
    }
}