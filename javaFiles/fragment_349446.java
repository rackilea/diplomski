@ManagedBean
@ApplicationScoped
public class AppBean implements HttpSessionListener {

    public AppBean() {
        ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        context.addListener(this);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        User user = userService.findBySessionId(session.getId());    
        connectedUsers.remove(user);
    }

    // ...
}