public class newJob implements Job{

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        try {
            FXMLLoader fxmlLoader = 
                        new FXMLLoader(getClass().getResource("path-to-fxml.fxml"));
            fxmlLoader.load();
            FXMLDocumentController fxmlDocumentController = 
                        (FXMLDocumentController)fxmlLoader.getController();
            fxmlDocumentController.runScheduledTests(); // convert the method to non-static
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}