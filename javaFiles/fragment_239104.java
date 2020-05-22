@Entity
@Table(name="UserRecordInfo")
public class UserRecordInfo {

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "UserID", nullable = false, updatable = false)
    @NotNull
    private User user;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}