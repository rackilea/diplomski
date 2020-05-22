import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Entity2")
public class Entity2 implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @ManyToMany(mappedBy = "list")
    private List<Entity1> otherList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Entity1> getOtherList() {
        return otherList;
    }

    public void setOtherList(List<Entity1> otherList) {
        this.otherList = otherList;
    }

}