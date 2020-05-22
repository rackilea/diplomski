try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setResources(ResourceBundle.getBundle("myprog/language/Base", Locale.getDefault()));
        rootScene = fxmlLoader.load(this.getClass().getResource("Base.fxml").openStream());
        controller = (BaseController) fxmlLoader.getController();
    } catch (IOException ex) {log.severe(ex.getMessage());}