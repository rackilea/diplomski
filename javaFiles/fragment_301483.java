class Button1Handler implements EventHandler<ActionEvent> {

    private final Stage window;
    private final Scene scene;

    public Button1Handler (Stage window, Scene scene) {
        this.window = window;
        this.scene = scene;
    }

     @Override
     public void handle (ActionEvent e) {
         System.out.println("OK button clicked");
         window.setScene(scene);  
    }
}