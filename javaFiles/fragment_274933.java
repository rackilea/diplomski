@ManagedBean @SessionScoped
public class LoginBean implements Serializable {
    private String userLogin;

    public void doLogin() { /* assign userLogin */ }
}

@ManagedBean @SessionScoped
public class SampleBean implements Serializable {
    @ManagedProperty("#{loginBean.userLogin}")
    private String login;
    private String greeting;

    public void sayHello() {
        greeting = "Hello " + login;
    }
}