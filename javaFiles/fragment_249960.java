public class YourAsyncTask extends AsyncTask<Void, Void, YourReturnType> {

     public interface OnFinishListener{
         void onFinish(YourReturnType result);
     }

     private OnFinishListener mListener;

     public OnFinishListener setOnFinishListener(@Nullable OnFinishListener l){
         mListener = l;
     }

     @Override
     protected YourReturnType doInBackground(Void... params) {
         // Replace all "YourReturnType" with the actual type/object you want to return
         YourReturnType returnValue; 

         // Do your work here and build/create your returnValue

         return returnValue;
     }

     // This will get called automatically after doInBackground finishes
     @Override
     protected void onPostExecute(YourReturnType result) {
         // If listener is set
         if(mListener != null){
             mListener.onFinish(result); // Return the returnValue
         }
     }
 }