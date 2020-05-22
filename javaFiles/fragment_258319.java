@FXML
public void loginButtonPress(ActionEvent event) {

    if (( ! username.getText().isEmpty()) || (! password.getText().isEmpty()) ) {

        loginLabel.setText("Please enter data in the fields below");

    } else {

        // I assume you want these values before you set them to "-----", no???
        final String uName = username.getText();
        final char[] pw = password.getText().toCharArray();

        username.setText("-----");
        password.setText("-----");

        // create task for retrieving data:

        Task<BackendInterface> loadDataTask = new Task<BackendInterface>() {

            @Override
            public BackendInterface call() throws Exception {

                BackendInterface backendInterface = new BackendInterface(uName, pw);
                if (backendInterface.openConnection()) {

                    if (backendInterface.getAllStudents() &&
                        backendInterface.getAllConsultations() &&
                        backendInterface.getCourses() &&
                        backendInterface.getConsultationCategories() &&
                        backendInterface.getConsultationPriorities()) {

                        return backendInterface ;
                    }
                 }

                 // maybe throw an exception here, depending on your requirements...
                 return null ;
            }

        };

        // show UI on task completion:

    loadDataTask.setOnSucceeded(e -> {

        BackendInterface backendInterface = loadDataTask.getValue();

        if (backendInterface == null) {
            // something went wrong... bail, or probably show error message...
            return ;
        }

        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("/main/res/dashboard.fxml"));
        Parent p = loader1.load();
        DashboardController controller = loader.getController();
        controller.setBackendInterface(backendInterface);

        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();

        // etc etc with your Images, etc (not sure why this isn't done in DashboardController though...)

        // set cursor back to default:
        loginLabel.getScene().setCursor(Cursor.DEFAULT);
    });

    loadDataTask.setOnFailed(e -> {
        // show error message or otherwise handle database exception here
    });

    // set cursor to WAIT:
    loginLabel.getScene().setCursor(Cursor.WAIT);

    // and run task in a background thread:
    Thread t = new Thread(loadDataTask);
    t.start();

}