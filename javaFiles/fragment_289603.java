public class MyActivity extends Activity
implements MyAsnycTask.OnTaskFinished
{

    @Override
    public void TimeToNextActivity()
    {
        // Here go to next activity
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }