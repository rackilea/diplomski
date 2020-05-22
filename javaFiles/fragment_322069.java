public void start(Stage primaryStage) {
    Pane pane = new Pane();
    primaryStage.setScene(new Scene(pane, 300, 300));
    primaryStage.show();

    pane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

    Thread thread = new Thread(() -> {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(str);
    });
    thread.start();
}