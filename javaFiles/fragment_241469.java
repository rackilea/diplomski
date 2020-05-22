import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class A {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="id_a")
    private Integer id;

    private String name;

    @OneToMany(mappedBy="a",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<AB> abAssociations = new ArrayList<>();

    // Getters and setters...
}