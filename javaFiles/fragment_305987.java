@Component
public class MyPostLoadEventListener implements PostLoadEventListener {

    @Resource
    private SessionFactoryImpl sessionFactoryImpl;
    @Resource
    private RestClient restClient;

    @PostConstruct
    public void installAsEventListener() {
        sessionFactoryImpl.getServiceRegistry()
                              .getService(EventListenerRegistry.class)
                              .getEventListenerGroup(EventType.POST_LOAD)
                              .appendListener(this);
    }

    @Override
    public void onPostLoad(PostLoadEvent event) {
        if (event.getEntity() instanceof LocalObject) {
            // fill with data from RestClient
        }
    }
}