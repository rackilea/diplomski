Parent parent=null;
FXMLLoader fxmlLoader=getFxmlLoader();
try {
    parent = (Parent)fxmlLoader.load(getFxmlStream("tasklist.fxml"));
    ComboBox<?> comboBox = (ComboBox<?>) fxmlLoader.getNamespace().get("testComboBox");
    System.out.println(comboBox);
} catch (IOException ex) {
    Logger.getLogger(TestGoView.class.getName()).log(Level.SEVERE, null, ex);
}