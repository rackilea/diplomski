@Override
public void start(Stage primaryStage) throws IOException {
    Button bA=new Button("Button A");
    Tooltip tA=new Tooltip("Sample tooltip A");
    tA.widthProperty().addListener((obs,b,b1)->System.out.println("A: "+tA.getWidth()));
    bA.setTooltip(tA);

    Button bB=new Button("Button B");
    Tooltip tB=new Tooltip("Sample tooltip B");
    tB.widthProperty().addListener((obs,b,b1)->System.out.println("B: "+tB.getWidth()));
    bB.setTooltip(tB);

    Button bC=new Button("Button C");
    Tooltip tC=new Tooltip("Sample tooltip C");
    tC.widthProperty().addListener((obs,b,b1)->System.out.println("C: "+tC.getWidth()));
    bC.setTooltip(tC);

    Button bD=new Button("Button D");
    Tooltip tD=new Tooltip("Sample tooltip D");
    tD.widthProperty().addListener((obs,b,b1)->System.out.println("D: "+tD.getWidth()));
    bD.setTooltip(tD);

    HBox root =new HBox(10,bA,bB,bC,bD);
    Scene scene = new Scene(root, 300, 250);
    scene.getStylesheets().add(getClass().getResource("root.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();

}