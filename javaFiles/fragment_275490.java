import javafx.application.Application;
import javafx.application.HostServices;

public class App extends Application {
    public void method(String[] args) {
        ClinicFiles clinicFiles = (ClinicFiles) listViewClinic.getSelectionModel().getSelectedItem();
        HostServices hostServices = getHostServices();
        hostServices.showDocument(clinicFiles.getAbsolutePath());
    }
}