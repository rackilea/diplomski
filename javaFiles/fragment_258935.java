@FXML
    private BorderPane borderPane;

    private AnchorPane achor1;
    private AnchorPane achor2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            achor1 = FXMLLoader.load(getClass().getResource(("/Views/anchor1.fxml")));
            achor2 = FXMLLoader.load(getClass().getResource("/Views/anchor2.fxml"));

        } catch (IOException ex) {
            Logger.getLogger(CrechHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void action1() throws IOException {
        // anchor1

        borderPane.setCenter(achor1);

    }

    @FXML
    public void action2() {
        //anchor2 

        borderPane.setCenter(achor2);
    }