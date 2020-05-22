FXMLLoader loader = new FXMLLoader();
loader.setLocation(Main.class.getResource("Resources/Game.fxml"));
Parent root = loader.load();
GameController gameManagerController = loader.getController();

loader = new FXMLLoader();
loader.setLocation(getClass().getResource("Resources/TopMenuBar.fxml"));
Parent topMenuBar = loader.load();
TopMenuBarController topMenuBarController = loader.getController();


ApplicationViewState viewState = new ApplicationViewState();
gameManagerController.setViewState(viewState);
viewState.setMenu(topMenuBar);