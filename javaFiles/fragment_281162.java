@Entity
@Table(name = "usersetting")
public class UserSetting implements Serializable {


    @EmbeddedId
    private UserSettingId userSettingId;

    private String value;

    public UserSetting() {
    }

    public UserSetting(UserSettingId userSettingId) {
        this.userSettingId = userSettingId;
    }

    public UserSettingId getUserSettingId() {
        return userSettingId;
    }

    public void setUserSettingId(UserSettingId userSettingId) {
        this.userSettingId = userSettingId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}