@ManagedBean(name="userUsed") // from javax.faces.bean, not javax.annotation
public class UserOfUserBean {

    @ManagedProperty("#{user}") 
    private User user;

    // Mandatory setter for JSF-native injection
    public void setUser(User user) {
        this.user = user;
    }
}