FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LabelCloseTest.fxml"));
Parent root = loader.load();

// gets instance from FXMLLoader, must be called after load()
FXMLDocumentController fdc = loader.getController(); 

fdc.closeLabelPressed();