@Embeddable
public class UserSettingId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "setting")
    private Setting setting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;

    public UserSettingId() {
    }

    public UserSettingId(Setting setting, User user) {
        this.setting = setting;
        this.user = user;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSettingId)) return false;
        UserSettingId that = (UserSettingId) o;
        return setting.equals(that.setting) &&
                user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(setting, user);
    }
}