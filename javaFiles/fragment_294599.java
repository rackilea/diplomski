import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "REVINFO")
@RevisionEntity(UserRevisionListener.class)
public class UserRevEntity extends DefaultRevisionEntity {
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "REV")
    private Integer id;

    @Column(name = "REVTSTMP")
    private BigInteger timestamp;

    // Make getter and setters

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }
}