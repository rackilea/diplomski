public class MainController {
   private ExecutorService executor = Executors.newSingleThreadExecutor();
   private GraphCreationSession graphSession ;

   @FXML
   private void createSession() { //invoked by a button click in the view

      if (graphSession != null && !graphSession.getState()==Worker.State.RUNNING) {
         //cancel previous session
         graphSession.cancel(true);
      }
      graphSession = new GraphCreationSession();
      graphSession.setOnSucceeded(event -> {
          Graph graph = graphSession.getValue();
          // update UI...
      });
      executor.execute(graphSession);
    }
 }