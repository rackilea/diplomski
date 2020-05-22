@Component
public class LoginController implements Initializable, ApplicationContextAware{

    @FXML
    private AnchorPane login;
    @FXML
    private JFXTextField dbUsernameTextField;
    @FXML
    private JFXPasswordField dbPasswordTextField;
    @FXML
    private JFXTextField boxUsernameTextField;
    @FXML
    private JFXPasswordField boxPasswordTextField;
    @FXML
    private JFXComboBox<ComboItem> environmentComboBox;
    @FXML
    private JFXButton loginButton;
    @Autowired 
    private Environment environment;

    @Autowired
    private OrderService orderService;

    private AnnotationConfigApplicationContext context;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginButton.setDisable(true);
        List<ComboItem> envs=new ArrayList<ComboItem>();
        String[]environments=environment.getProperty("environments").split(",");
        for(String s:environments) {
            environmentComboBox.getItems().add(new ComboItem(s.toUpperCase(),s));
        }
        environmentComboBox.setConverter(new StringConverter<ComboItem>() {
            @Override
            public String toString(ComboItem object) {
                return object.getKey();
            }
            @Override
            public ComboItem fromString(String string) {
                return null;
            }
        });
    }

    @FXML
    public void selectEnvironment() {
        if(!environmentComboBox.getSelectionModel().isEmpty())
            loginButton.setDisable(false);
    }

    @FXML
    public void authenticate(ActionEvent actionEvent) {

        String boxUsername=boxUsernameTextField.getText();
        String boxPassword=boxPasswordTextField.getText();
        try {
            context.registerBean("dataSource",DataSource.class,()->dataSource());
            context.registerBean("sessionFactory", LocalSessionFactoryBean.class,()->sessionFactory());     
            context.registerBean("transactionManager",HibernateTransactionManager.class,()->getTransactionManager());

            Order order=orderService.findById("");

            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
            fxmlLoader.setControllerFactory(context::getBean);
            Parent rootNode=fxmlLoader.load();
            Stage stage=(Stage) login.getScene().getWindow();
            Scene scene=new Scene(rootNode,400,300);
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.setMaximized(true);
            stage.show();
            stage.setOnCloseRequest(event->JSchConnection.close());
        }catch(Exception e) {
        context.removeBeanDefinition("dataSource");
        context.removeBeanDefinition("sessionFactory");
        context.removeBeanDefinition("transactionManager");

            e.printStackTrace();
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=(AnnotationConfigApplicationContext) applicationContext;       
    }

    private  Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "none");
        return properties;
    }

    public  DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("myurl");
        dataSource.setUsername(dbUsernameTextField.getText());
        dataSource.setPassword(dbPasswordTextField.getText());
        return dataSource;
    }

    public  LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.mypackage" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(context.getBean(SessionFactory.class,"sessionFactory"));
        return transactionManager;
    }

}