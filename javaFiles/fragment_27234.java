/** Called when the user clicks the Send button */
  public void sendSOS(View view) {
      Camera cam = null;
      try{
         cam = getCameraInstance();
         ...
      }
      catch(Exception e){
         // TODO: if camera is null 
         // find a work around
         // either prompt user that camera is still not available
         // or(bad idea) recursion with ProgressBar
         // like sendSOS(view); and let the user wait using Handler
         // if these doesnt work, add a callback to the camera
         // `Camera.ErrorCallback`
         // if CAMERA_ERROR_SERVER_DIED will return in `onError(int,Camera)`
         // then In this case, the application must release the Camera object and instantiate a new one.
      }
      finally{
         // this should be in a worker thread, and use a callback if camera is already release
         // in some cases this should work, but in order not to block the main thread
         // we can use asynctask to release the camera resources here and use a callback
         // whenever the onPostExecute executes, then trigger a function that camera is ready again to              
         // be opened
         cam.release(); 
      }
  }