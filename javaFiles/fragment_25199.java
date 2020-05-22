FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LabelCloseTest.fxml"));
Parent root = loader.load();

FXMLDocumentController fdc = new FXMLDocumentController(); // the real problem

fdc.closeLabelPressed(); // accesses the labelTest field which is null