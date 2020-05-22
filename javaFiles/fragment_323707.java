@Override
public void start(Stage primaryStage) {
    MediaPlayer player = new MediaPlayer(new Media("http://www.archive.org/download/moby_dick_librivox/mobydick_000_melville.mp3"));
    MediaView view = new MediaView(player);
    Pane root = new Pane(view);
    Scene scene = new Scene(root);

    primaryStage.setTitle("Mp3 player");
    primaryStage.setScene(scene);
    primaryStage.show();
    player.play();

    new Thread(() -> { 
        Scanner sc = new Scanner(System.in);
        System.out.println("enter 1 to pasue");
        int option = sc.nextInt();
        if (option == 1) {
            player.stop();
        }
    }).start();
}

public static void main(String[] args) {
    launch(args);
}