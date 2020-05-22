@SpringBootApplication
public class JavaFxApplication extends Application {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        context = springBootApplicationContext();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pac-Man");
        primaryStage.getIcons().add(new Image("images/pacman/pacman.png"));
        Parent root = new LoginPage(primaryStage);
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add("stylesheet/stylesheet.css");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        context.close();
    }

     private ConfigurableApplicationContext springBootApplicationContext() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(JavaFxApplication.class);
        String[] args = getParameters().getRaw().stream().toArray(String[]::new);
        return builder.run(args);
    }
}