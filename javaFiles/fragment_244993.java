public void showMainView(String sessionID) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));
        // mMainController = loader.<MainController>getController();
        mMainScene.setRoot((Parent) loader.load());

        mMainController = loader.<MainController>getController();

        System.out.println("pointer adress = " + mMainController);
        mMainController.initManager(this);
    } catch (IOException ex) {
        Logger.getLogger(ControllerManager.class.getName()).log(Level.SEVERE, null, ex);
    }
}