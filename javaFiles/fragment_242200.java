import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class AddTabsController  {

    @FXML
    private TabPane tabPane ;

    public void initialize() {
        tabPane.getTabs().add(new Tab("Tab 1"));
    }

    @FXML
    private void addTab() {
        int numTabs = tabPane.getTabs().size();
        Tab tab = new Tab("Tab "+(numTabs+1));
        tabPane.getTabs().add(tab);
    }

    @FXML
    private void listTabs() {
        tabPane.getTabs().forEach(tab -> System.out.println(tab.getText()));
        System.out.println();
    }
}