public class DeviceConfigurationController {

    @FXML private ListView<DeviceConfiguration> device_list;
    private boolean pauseListener;

    @FXML
    private void initialize() {
        device_list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(!pauseListener)
               UndoManager.add(new ListViewSelectionChange<>(oldValue, device_list));
            }            
        });
    }

    @FXML
    private void undo() {
        pauseListener = true;
        UndoManager.undo();
        pauseListener = false;
    }
}