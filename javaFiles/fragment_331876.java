FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("/ooppFinalProject/view/HomePage1.fxml"));
myScene = (Scene) ((Node) event.getSource()).getScene();
Stage stage = (Stage) (myScene).getWindow();
Parent nextView = loader.load();
WorkerHomeController workerHome=loader.getController();
workerHome.cancelTimer();