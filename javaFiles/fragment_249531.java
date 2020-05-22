package ui.root;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import model.Model;
import ui.login.LoginController;
import ui.menu.MenuController;

public class RootPane extends BorderPane {

    private final Model model ;

    public RootPane() throws Exception {
        model = new Model();
        model.loggedInProperty().addListener((obs, wasLoggedIn, isLoggedIn) -> {
            if (isLoggedIn) {
                showMenu();
            } else {
                showLogin();
            }
        });

        FXMLLoader loader = new FXMLLoader(getClass().getResource("root.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
        showLogin();
    }

    private void showMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/menu/menu.fxml"));
            setCenter(loader.load());
            MenuController controller = loader.getController();
            controller.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/login/login.fxml"));
            setCenter(loader.load());
            LoginController controller = loader.getController();
            controller.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
}