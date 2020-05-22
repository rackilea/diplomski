public class AsyncTaskMessage extends AsyncTask<Void, Void, Void> {


    Context context;
    public OnMessageListener mListener;

    public interface OnMessageListener {
        void messageCallback(ArrayList<String> messageList); // you can change the parameter here. depends on what you want.
    }

    public AsyncTaskMessage(Context context) {
        this.context = context;
        mListener = (OnMessageListener) context;
    }

    @Override
    public void onPreExecute() {

    }

    @Override 
    protected void onPostExecute() {
        // your code goes here for the callback.
        // messageList - A list of messages.
        mListener.messageCallback(messageList);
    }
}