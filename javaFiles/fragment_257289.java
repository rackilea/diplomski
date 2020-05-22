public class AdmissionController {

    private ObservableList<StudentMaster> data ;

    public void setStudentData(ObservableList<StudentMaster> data) {
        this.data = data ;
    }

    // existing code...

    @FXML
    void doneBtnClicked(ActionEvent event)
    {
        String name = nameBox.getText();
        String SQLquery = "INSERT INTO student (student_name) VALUES ('"+name+"')";
        ExecuteSQL newQuery = new ExecuteSQL();
        boolean executeStatus = newQuery.ExecuteSQL(SQLquery);
        System.out.println(executeStatus ? "Data Inserted" : "Error in execution");    

        if (executeStatus) {
            StudentMaster student = new StudentMaster(...);
            data.add(student);
        }

        //        Close the Window after successfully inserted

        Node node = (Node)event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
    }  

    // ...
}