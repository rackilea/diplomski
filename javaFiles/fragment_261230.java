FXMLLoader loader = new FXMLLoader();
URL fxmlLocation = getClass().getResource("/fxml/main_screen.fxml");
loader.setLocation(fxmlLocation);
loader.setController(mainScreenController);
loader.setResources(ResourceBundle.getBundle("i18n/Text", new Locale("sv", "SE")));
Pane pane = loader.<Pane>load();
Scene scene = new Scene(pane);