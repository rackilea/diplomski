import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tests")
public class Test {

    @Id
    @Column(name="idtest")
    private int id ;
    private String title ;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Test) {
            return Objects.equals(title, ((Test)other).title);
        } else return false ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}