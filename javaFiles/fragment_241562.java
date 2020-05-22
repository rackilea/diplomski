private class MyTask extends AsyncTask<X, Y, Z>
{

 protected void onPreExecute(){
      //any specific setup before you start copy() method ,  runs on UI 
      // thread
 } 

 protected Z doInBackground(X...x){
     // your copy() method itself, runs on worker thread other than main UI 
     //  thread, don't perform any UI related activities from here , since 
    // it is the worker thread
 }

 protected void onProgressUpdate(Y y){
   //any event you wanna perform , while the task is in progress, runs on 
   //UI main thread
 }

 protected void onPostExecute(Z z){
  //the event you wanna perform once your copy() method is complete, runs 
  //on UI main thread
}
}