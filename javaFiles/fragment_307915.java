@SpringBootApplication
public class BootFXApplication {

    public static void main(String[] args) {
        Application.launch(BootFX.class, args);
    }

    @Bean
    protected static Application bootFx() {

        // I declare this bean this way so I can use
        // the static instance stored when JavaFX
        // calls the no-arg 'BootFX' constructor
        // via reflection.

        if (BootFX.instance == null) {
            BootFX.instance = new BootFX();
        }

        return BootFX.instance;
    }

    public static class BootFX extends Application {

        private static BootFX instance;

        private ConfigurableApplicationContext applicationContext;

        public BootFX() {
            BootFX.instance = this;
        }

        @Override
        public void init() throws Exception {

            String[] args = !isNull(getParameters()) ? 
                    getParameters().getRaw().toArray(new String[]{}) : new String[]{};

            applicationContext = new SpringApplicationBuilder(BootFXApplication.class)
                    .run(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {

            FXMLLoader loader = new FXMLLoader(Charset.forName("UTF-8"));
            loader.setLocation(new ClassPathResource("fxml/main-pane.fxml").getURL());

            // This is the secret-sauce, have JavaFX get controllers from Spring
            loader.setControllerFactory(applicationContext::getBean);

            primaryStage.setTitle("Spring Boot + JavaFX");
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        }

        @Override
        public void stop() throws Exception {
            SpringApplication.exit(applicationContext);
        }
    }


    @Bean
    public MainPaneController getMainController() {
        return new MainPaneController();
    }

}

// You would have this in a separate class, and could mark as
// @Component instead of declaring the MainPaneCtrl bean above
class MainPaneController {

    @FXML
    private BorderPane rootPane;

    public void initialize() {
        System.out.println(rootPane.toString());  // Mess around with your root pane here, i.e. set bindings
    }
}