package gui;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private Stage stage = null;

    @FXML
    private AnchorPane mainContainer;

    @FXML
    private VBox vBoxContainer;

    @FXML
    private MenuBar menuBarTop;

    @FXML
    private HBox hBoxContainer;

    @FXML
    private StackPane navigationSection;

    @FXML
    private TreeView<String> treeView;



    final private TreeItem<String> rootIssues = new TreeItem<String>("IssueTracker");
    final private TreeItem<String> issuesTable = new TreeItem<String>("IssuesTable");
    final private TreeItem<String> stickers = new TreeItem<String>("Stickers");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootIssues.setExpanded(true);
        rootIssues.getChildren().addAll(issuesTable, stickers);
        treeView.setRoot(rootIssues);

    }

    public void setStage(Stage stage)   {
        this.stage = stage;
        stage.setResizable(true);
        stage.setTitle("SoloStats - Welcome");
    }

    public void closeStage()    {
        if (this.stage != null) {
            this.stage.close();
        }
    }
}