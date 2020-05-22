public class AsyncTaskName extends AsyncTask<IN_PARAMETER, PROGRESS_PARAMETER, RETURN_PARAMETER> {
    @Override
    protected RETURN_PARAMETER doInBackground(IN_PARAMETER... params) {
         // do your stuff
         return (variable of type RETURN_PARAMETER);
    }

    @Override
    protected void onProgressUpdate(PROGRESS_PARAMETER... progress) {
         // do your stuff
    }

    @Override
    protected void onPostExecute(RETURN_PARAMETER returnParam) {
         // interact with your UI, like calling a method from your activity
    }
}