public class MyAsnycTask extends AsyncTask
{

    OnTaskFinished listener;

    // Our simple interface
    public interface OnTaskFinished {
        void TimeToNextActivity();
    }

    // Your MyAsnycTask class constructor
    public MyAsnycTask(OnTaskFinished l) {
        listener = l;
    }

    . . .