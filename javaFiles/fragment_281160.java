@Entity
@Table(name = "setting")
public class Setting {

    private String key;
    private String value;

    @Id
    @Column(name = "name", nullable = false, unique=true,columnDefinition="VARCHAR(255)")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}