package webviewinputvalue;

public class WebviewInputValue extends Application {

    private WebView InitWebview(){

        //Create browser
        WebView browser = new WebView();
        WebEngine render = browser.getEngine();

        //Load simple HTML
        String editor = WebviewInputValue.class.getResource("editor.html").toExternalForm();
        render.load(editor);

        //Listen for state change
        render.getLoadWorker().stateProperty().addListener((ov, o, n) -> {
            if (Worker.State.SUCCEEDED == n) {
                render.setOnStatusChanged(webEvent -> {

                    //Call value change
                    onValueChange(webEvent.getData());
                });
            }
        });

        return browser;
    }

    //called when value changes
    private void onValueChange(String data){

        //Print out data
        System.out.println(data);

        //If the data is equal to "exit", close the program
        if("exit".equals(data)){

            //Print goodbye message
            System.out.println("Received exit command! Goodbye :D");

            //Exit
            System.exit(0);
        }
    }

    @Override
    public void start(Stage primaryStage) {

        //Create browser
        WebView browser = InitWebview();

        StackPane root = new StackPane();
        root.getChildren().add(browser);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}