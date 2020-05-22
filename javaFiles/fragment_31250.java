public class SelectScene  {


    private Callback<Class<?>, Object> controllerFactory ;

    public SelectScene(final List<...> data) {
        controllerFactory = new Callback<Class<?>, Object>() {
            @Override
            public Object call(Class<?> type) {
                try {
                    Constructor<?> constructor = type.getDeclaredConstructor(List.class);
                    return constructor.newInstance(data);
                } catch (NoSuchMethodException exc) {
                    return type.newInstance();
                } catch (Exception ex) {
                    // trouble...
                    ex.printStackTrace();
                    return null ;
                }
            }
         };
    }

    public void setScene(String fxmlFileName, String title, ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
        loader.setControllerFactory(controllerFactory);
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(FinalDossier.class.getResource("style.css").toExternalForm());
        stage.setTitle(title);
        stage.setScene(scene);
    }
}