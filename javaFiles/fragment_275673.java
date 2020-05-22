public abstract class AsyncTask < Params, Progress, Result> {

      protected abstract Result doInBackground(Params... params);

      protected void onPostExecute(Result result) {}

      protected void onProgressUpdate(Progress... values) {}
}