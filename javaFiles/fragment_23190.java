import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;

public class MainController {

    @FXML
    private TabPane tabPane;
    @FXML
    private Tab tab1;
    @FXML
    private Tab tab2;
    @FXML
    private Tab tab3;

    @FXML
    private void initialize() {

        // Our TabPane has 3 Tabs. Let's populate them with content, reusing our TabContent.fxml file
        setTabContent(tab1, new Tab1Controller());
        setTabContent(tab2, new Tab2Controller());
        setTabContent(tab3, new Tab3Controller());

    }

    /**
     * Sets the content of Tab to the TabContent.fxml document
     *
     * @param tab        The Tab whose content we wish to set
     * @param controller The controller for this particular Tab's content
     */
    private void setTabContent(Tab tab, TabController controller) {

        // Load our TabContent.fxml file and set it as the content of the Tab that was passed to this method
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TabContent.fxml"));

            // Set the controller for this specific tab
            loader.setController(controller);

            // Set the content of the passed Tab to this FXML content
            tab.setContent(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}