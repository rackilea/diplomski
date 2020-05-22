@ManagedBean(eager=true)
@ApplicationScoped
public class MyApplicationBean {

    @PostConstruct
    public void onPostConstruct() {
        // Put code here which should be executed on application's startup.
    }

    @PreDestroy
    public void onPreDestroy() {
        // Put code here which should be executed on application's shutdown.
    }

}