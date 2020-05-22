//ensure this class is discoverable via the component-scan of your app-context.xml
@Configuration
public class MyConfig {

    //..

    @Autowired
    @Bean(name = "deleteButton")
    public ActionListenerButton deleteButton(@Qualifier("deleteButtonActionListener") ???Type deleteButtonActionListener) {
        ActionListenerButton deleteButton = new ActionListenerButton();
        deleteButton.setActionListener(deleteButtonActionListener);
        deleteButton.setText("Delete");
        deleteButton.init();
        return deleteButton;
    }

    //..
}