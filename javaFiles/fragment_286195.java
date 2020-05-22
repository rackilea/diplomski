public class Controller implements Initializable {
    @FXML private BorderPane container;

    // ...

    public void load(Views view){
        if (views.containsKey(view)) {
            Node newView = views.get(view);
            container.setCenter(newView);

        } else {
            System.out.println("Error: key not found in map");
        }
    }

}