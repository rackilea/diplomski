public class ExampleTask extends AsyncTask<Void, Void, String> {

    public interface TaskListener {
        public void onFinished(String result);
    }

    // This is the reference to the associated listener
    private final TaskListener taskListener;

    public ExampleTask(TaskListener listener) {
        // The listener reference is passed in through the constructor
        this.taskListener = listener;
    }

    @Override
    protected String doInBackground(Void... params) {
        return doSomething();
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        // In onPostExecute we check if the listener is valid
        if(this.taskListener != null) {

            // And if it is we call the callback function on it.
            this.taskListener.onFinished(result);
        }
    }
}