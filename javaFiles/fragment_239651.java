import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bar {

    @Id
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}