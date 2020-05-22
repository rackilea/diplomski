@Inject private UserBean userBean;
String username;

@PostConstruct
public void init() {
    username = userBean.getUsername();
}