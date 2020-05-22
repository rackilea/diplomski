public class YourTask extends AsyncTask<UIWrapper, Void, Void> {
    SomeUiCallback mCallback;
     protected void doInBackground(UIWrapper... wrapper) {
         mCallback = UiWrapper.callback;
         UIWrapper.runnable.run();
     }

     protected void onProgressUpdate() {
     }

     protected void onPostExecute() {
        mCallback.runYourUiStuff();
     }
 }