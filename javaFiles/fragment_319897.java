public class YourAsyncTask extends AsyncTask<Void, Void, String> {

    // Declare an interface 
    public MyResponseListener myResponse;

    // Now in your onPostExecute
    @Override
    protected void onPostExecute(final String result) {
        // Send something back to the calling Activity like this to let it know the AsyncTask has finished. 
        myResponse.myResponseReceiver(result);
    }
}