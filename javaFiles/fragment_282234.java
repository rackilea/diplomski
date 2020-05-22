public class LoginDialog extends Dialog<SomeDataType> {

    public LoginDialog(Data data) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/LoginDialog.fxml"));
            Parent root = loader.load();
            LoginDialogController controller = loader.<LoginDialogController>getController();
            controller.setModel(new LoginModel(data));
            getDialogPane().setContent(root);

            setResultConverter(buttonType -> {
                SomeDataType someData = ... ;
                return someData ;
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}