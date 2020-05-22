@ManagedProperty(value="#{param.userId}")
private Long userId;

@ManagedProperty(value="#{sessionBean}")
private SessionBean sessionBean;

@PostConstruct
public void init() {
    sessionBean.setUser(em.find(User.class, userId));
    // ...
}