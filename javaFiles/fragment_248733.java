Service<Void> service = new Service<Void>() {
         @Override
             protected Task<Void> createTask() {
                 return new Task<Void>() {
                     @Override
                     protected Void call()throws InterruptedException {
                         updateMessage("Initializing Task");
                                      updateProgress(0, 10);
                                      for (int i = 0; i < 10; i++) {
                                          Thread.sleep(300);
                                          //DO BACKGROUND WORK HERE

                                          Platform.runLater(new Runnable {
                                              @Override
                                              public void run() {
                                                   //DO LIVE SCENE GRAPH WORK HERE
                                              }
                                          });

                                          updateProgress(i + 1, 10);
                                          updateMessage("Progress Msg");
                                       }
                         updateMessage("Finished");
                         return null;
                     }
               };
             }
         };

         //Once you have your worker, you can create the status dialog
         Dialogs.create()
                 .owner(stage)
                 .title("Progress Dialog")
                 .masthead("Doing The Thing")
                 .showWorkerProgress(service);

         service.start();