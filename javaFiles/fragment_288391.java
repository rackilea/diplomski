@EntryPoint
public class Bootstrap
{

    @Inject
    Navigation navigation;


    @PostConstruct
    public void buildUI()
    {
        navigation.getContentPanel().setWidth("100%");
        navigation.getContentPanel().setHeight("100%");
        RootPanel.get().add(navigation.getContentPanel());
    }

}