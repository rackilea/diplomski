public class Client extends Application {
    //Create a ExecutorService threadpool
    ExecutorService threadPool = Executors.newWorkStealingPool();

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Hello world!");
        Button btn = new Button();
        btn.setText("Run Client");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    //submit a new task to the threadPool which will be executed on another thread.
                    threadPool.execute(new Runnable() {
                        @Override
                        public void run() {
                            runClient();
                        }
                    });
                } catch (Exception e) {
                    System.out.println("Exception Occurred, Server is down.");
                }
            }
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(btn);
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    public void runClient() throws Exception {
        String sentence;
        String modSentence;
        BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + "\n");
        modSentence = inFromServer.readLine();
        System.out.println("From Server: " + modSentence);
        clientSocket.close();

        //############# Run something in the FXThread #############\\
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //do some UI stuff like updating labels
            }
        });
    }
}