import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "preference")
public class Preference {
    private Long pref_id;
    private String prefName;
    private Set<UserPreferences> userPrefs;

    @Id
    @Column(name = "pref_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return pref_id;
    }

    public void setId(Long id) {
        this.pref_id = id;
    }

    @Column(name = "PREF_NAME")
    public String getPrefName() {
        return prefName;
    }

    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }

    @OneToMany(mappedBy = "preference")
    public Set<UserPreferences> getUserPrefs() {
        return userPrefs;
    }

    public void setUserPrefs(Set<UserPreferences> userPrefs) {
        this.userPrefs = userPrefs;
    }
}