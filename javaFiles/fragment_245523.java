protected Void doInBackground(Integer... params) {
   int command = params.length > 0 ? params[0] : 0;
   switch (command) {
   case CONNECT:
       connect();
       break;
   case DOWNLOAD:
       download();
       break;
   case PAUSE:
       abortConnection();
       break;
    }
    return null;
}