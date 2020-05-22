@Service
@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionHolder {

    private User user = null;

    @Autowired
    public SessionHolder(SimpMessagingTemplate template) {
        this.template = template;
    }

    @EventListener(SessionConnectedEvent.class)
    public void handleSessionConnected(SessionConnectedEvent event) {
        if (user == null && event.getUser() != null) {
            StompHeaderAccessor ha = StompHeaderAccessor.wrap(event.getMessage());
            user = SessionUtils.getUser(ha);
        }
    }

    public User getUser() {
        return user;
    }

}