public class SecondController {

    private final Set<String> selectedData = new TreeSet<>();

    public Set<String> getSelectedData() {
        return selectedData ;
    }

    @FXML
    private void addSelection (MouseEvent e) {
        // it almost never makes sense to define an event handler on a button, btw
        // and it rarely makes sense to test the source of the event
        if (event.getSource() == button){
           stage = (Stage) button.getScene().getWindow();
           selectedData.addAll(listSelection)
           stage.close();
        }
    }

}