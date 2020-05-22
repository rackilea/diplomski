@ManagedBean
@SessionScoped
public class User {

    @ManagedProperty("#{appBean}")
    private AppBean appBean;

    @PreDestroy
    public void destroy() {
        appBean.getConnectedUsers().remove(this);
    }

    // ...
}