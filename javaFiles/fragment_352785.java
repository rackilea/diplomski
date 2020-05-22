import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    private Long user_id;
    private String userName;
    private Set<UserPreferences> userPrefs;

    /**
     * @return Returns the userName.
     */
    @Column(name = "USER_NAME")
    public String getUserName() {
        return this.userName;
    }

    /**
     * @param userName
     *            The userName to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.user_id;
    }

    public void setId(Long id) {
        this.user_id = id;
    }

    /**
     * Lazy fetch of the set of application attributes this user has set.
     * 
     * @return
     */
    @OneToMany(mappedBy = "user")
    public Set<UserPreferences> getUserPrefs() {
        return this.userPrefs;
    }

    /**
     * Setter for the user's attributes.
     * 
     * @param userAttributes
     */
    public void setUserPrefs(Set<UserPreferences> userPrefs) {
        this.userPrefs = userPrefs;
    }

}