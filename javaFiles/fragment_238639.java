public static void showClientView(Client client) throws IOException { // Taking the client-object as an argument from LoginViewController
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("ClientView.fxml"));
    mainLayout = loader.load();

    ClientViewController cvc = loader.getController(); // This did the "trick"
    cvc.setClient(client); // Passing the client-object to the ClientViewController

    Scene scene = new Scene(mainLayout, 900, 600);
    primaryStage.setScene(scene);
    primaryStage.setResizable(true);
    primaryStage.show();
}