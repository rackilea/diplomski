import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Entity1")
public class Entity1 implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;      

    @ManyToMany
    @JoinTable(name = "Entity1_Entity2",
             joinColumns = { @JoinColumn(name = "Ref1", referencedColumnName = "ID") },
             inverseJoinColumns = { @JoinColumn(name = "Ref2", referencedColumnName = "ID") })
    private List<Entity2> list = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Entity2> getList() {
        return list;
    }

    public void setList(List<Entity2> list) {
        this.list = list;
    }
}