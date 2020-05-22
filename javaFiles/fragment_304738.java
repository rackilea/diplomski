public class Main extends Application {

    private TextField tf = new TextField();
    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream input ;
    private DataOutputStream output;
    // Text area for displaying contents
    TextArea ta = new TextArea();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {


        // Create a server socket
        BorderPane borderPaneForText = new BorderPane();
        Button btnSend = new Button("|>");
        btnSend.setOnAction( e-> {

            Platform.runLater( () -> {
                try{

                    output.writeUTF(tf.getText());
                    showMessage("server: " + tf.getText() + "\n");

                }
                catch(IOException ex){
                    ex.printStackTrace();
                }
            });
        });

        tf.setAlignment(Pos.BOTTOM_RIGHT);

        borderPaneForText.setCenter(tf);
        borderPaneForText.setRight(btnSend);
        borderPaneForText.setPadding( new Insets( 5, 5, 5, 5) );

        BorderPane mainPane = new BorderPane();
        mainPane.setTop(new ScrollPane(ta));
        mainPane.setCenter(borderPaneForText);

        // Create a scene and place it in the stage
        Scene scene = new Scene(mainPane, 450, 270);
        primaryStage.setTitle("Server"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        ta.setEditable(false);
        new Thread( () -> {
            try {
                // Create a server socket
                serverSocket = new ServerSocket(8000);
                Platform.runLater(() ->
                        ta.appendText("Server started at " + new Date() + '\n'));

                // Listen for a connection request
                Socket socket = serverSocket.accept();

                // Create data input and output streams
                input = new DataInputStream( socket.getInputStream() );
                output = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    // Receive message from the client
                    String message = input.readUTF();

                    output.writeUTF(message);
                    Platform.runLater(() -> {
                        ta.appendText("Client: " + message + "\n");
                    });
                }
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }




    public void showMessage(String message){

        Platform.runLater( () -> {
            ta.appendText(message);

        });
    }



}