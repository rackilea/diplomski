public class ExampleTask extends AsyncTask<Void, Void, String> {

    public interface TaskListener {
        public void onFinished(String result);
    }

    ...
}