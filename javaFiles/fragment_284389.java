FXMLLoader loader = new FXMLLoader(getClass().getResource("/myproject/Forms/userProfile.fxml"));
loader.setControllerFactory(applicationContext::getBean);
Parent root = loader.load();

// since everything can be initialized in the controller by D.I., you
// shouldn't need to access it, but if you do for some reason you can do

UserProfile controller = loader.getController();