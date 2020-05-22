String name, sname;
TextFlow textFlow = new TextFlow();
ScrollPane sp = new ScrollPane();
TextField userTextField = new TextField();
TextField fTextField = new TextField();
String recip;
Button button = new Button("Send");
//not used int i = 0;

public Parent content() {
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));
    Text scenetitle = new Text("Welcome");
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    grid.add(scenetitle, 0, 0, 2, 1);
    Label userName = new Label("User Name:");
    grid.add(userName, 0, 1);
    grid.add(userTextField, 1, 1);
    Label fName = new Label("Friend Name:");
    grid.add(fName, 0, 2);
    grid.add(fTextField, 1, 2);
    Button button = new Button("Start");
    DropShadow shadow = new DropShadow();
    button.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
        button.setEffect(shadow);
    });
    button.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
        button.setEffect(null);
    });
    button.setOnAction(e ->
    {
        //Show value on console
        System.out.println("user name\t"+userTextField.getText());
        System.out.println("friend name\t"+fTextField.getText());
        //should not hide.
        //grid.getScene().getWindow().hide();

        if(userTextField.getText().equals("matched value") & fTextField.getText().equals("matched value"))
        {                
            //show new pane onto current pane
            createContent(); // you should fix the function
            grid.setVisible(false); // hide current pane
            textFlow.setVisible(true);// show up new pane
        }
        else
        {
            //do something to remind user
        }
    });
    grid.add(button, 1, 6);

    // this should do in the Event Listener 
    //String name;
    //name = userTextField.getText();
    //System.out.println(name);
    //recip = fTextField.getText();
    //System.out.println(recip);

    return grid;
}

//create your second pane here.
public Parent createContent() {
    textFlow.setPadding(new Insets(10));
    textFlow.setLineSpacing(10);
    TextField textField = new TextField();
    textField.setPrefSize(300, 30);
    button.setPrefSize(80, 30);
    VBox container = new VBox();
    VBox box = new VBox();
    box.getChildren().addAll(sp, textFlow);
    container.setPadding(new Insets(10));
    container.getChildren().addAll(box, new HBox(textField, button));
    VBox.setVgrow(sp, Priority.ALWAYS);
    VBox.setVgrow(textFlow, Priority.ALWAYS);
    return container;
}

@Override
public void start(Stage stage) throws IOException {
    Parent q = content();
    Scene scene = new Scene(q, 300, 400);
    stage.setScene(scene);
    stage.setTitle("Chit-Chat");
    stage.show();


    /* no, not work here
    if (i == 1) {
        VBox vb = new VBox();
        vb.getChildren().addAll(textFlow);
        sp.setVmax(440);
        sp.setPrefSize(400, 300);
        sp.setContent(vb);
        sp.vvalueProperty().bind((ObservableValue<? extends Number>) vb.heightProperty());
        Parent p = createContent();
        Scene scene2 = new Scene(p, 400, 300);
        stage.setScene(scene2);
        stage.setTitle("Chit-Chat");
        stage.show();
    }*/

}

public static void main(String[] args) throws IOException {
    launch(args);
}