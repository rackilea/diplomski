public String service() {
    String track_id;

    // Generate new track id for each call somehow
    // let us put as 123 for simplicity
    track_id = "123";

    //Asynchronous thread
    (new Thread() {
        public void run() {
          // Execution that may take 1 minute goes here ....
       }
    }).start();

   return track_id;
 }