public class MessageCentre {

    Context context;
    public void MessageCentre(Context context) {
        this.context = context;
    }

    public void getMessages(int id) {
        // You said your asyncTask goes here.
        AsyncTaskMessage async = new AsyncTaskMessage(context);
        async.execute();
    }
}