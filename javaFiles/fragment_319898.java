public class MainActivity extends Activity implements MyResponseListener {
    // Your onCreate and other function goes here 

    // Declare an AsyncTask variable first
    private YourAsyncTask mYourAsyncTask;

    // Here's a function to start the AsyncTask
    private startAsyncTask(){
        mYourAsyncTask.myResponse = this;
        // Now start the AsyncTask 
        mYourAsyncTask.execute();
    }

    // You need to implement the function of your interface 
    @Override
    public void myResponseReceiver(String result) {
        if(!result.equals("5")) {
            // You need to keep track here how many times the AsyncTask has been executed. 
            startAsyncTask();
        }
    }
}