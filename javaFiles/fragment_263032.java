interface FxmlController{
  boolean isPrividingScene(String nextSceneIdOrName);
  String getFXMLLocation();
}


public class SceneSwitcher{
    public Stage window;
    public Parent root;
   private static ServiceLoader<FxmlController> sceneControllers
     = ServiceLoader.load(FxmlController.class);
    public void switchSceneFXML(String nextSceneIdOrName) throws Exception{
        try{
            window = (Stage) node.getScene().getWindow();
            for(FxmlController controller : sceneControllers){
               if(controller.isPrividingScene(nextSceneIdOrName)){ // however you want to select the next scene...
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setController(controller);
                 root = fxmlLoader.load(controller.getClass().getResource(controller.getFXMLLocation()));
                 window.setScene(new Scene(root));
                 window.show();
               }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}