public class MainController {

    private Task<Graph> graphSession ;
    // ...

    @FXML
    public void createSession() {

        // ...

        graphSession = new Task<Graph>() {
            @Override
            public Graph call() throws Exception {
                return new GraphCreationSession().call();
            }
        };

        graphSession.setOnSucceeded(...);
        executor.execute(graphSession);
   }
}