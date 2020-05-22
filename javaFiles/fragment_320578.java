new SwingWorker<T,T>(){
        @Override
        public Void doInBackground(){
           return t;  //Object of some type T 
        }

       @Override
       public void done() {
          try {
              T somVariable = get();
              // Use someVariable to update the GUI 
           }
          catch (InterruptedException ignore) {
             // handle exception
          }
          catch (java.util.concurrent.ExecutionException e) {
            // handle exception
          }
       }.execute();