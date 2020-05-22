if ("Initiate Recall".equalsIgnoreCase(ae.getActionCommand())) {
           // viewAllMembers method name should begin with a lower-case letter 
           oh.viewAllMembers();
           SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
              @Override
              protected Void doInBackground() throws Exception {
                 oh.doRecall();
                 return null;
              }

              @Override
              protected void done() {
                 try {
                    get();
                 } catch (InterruptedException | ExecutionException e) {
                    // do something with any exceptions here
                    e.printStackTrace();
                 }
              }
           };
           worker.execute();
        }