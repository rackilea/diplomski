@FXML
void createStudent(ActionEvent event)
{
    FXMLLoader fxmlLoader;
    fxmlLoader = new FXMLLoader(getClass().getResource("/resources/fxml/newStudent.fxml"));
    try {
        Parent root1 = (Parent)fxmlLoader.load();

        AdmissionController admissionController = fxmlLoader.getController();
        admissionController.setStudentData(studentTable.getItems());

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Admission");
        stage.setScene(new Scene(root1));
        stage.show();
    } catch (IOException e)
    {
        e.printStackTrace();
    }
}