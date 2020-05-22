package forum7278406;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Dependency {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional=false)
    @Column(name="target_id")
    @XmlJavaTypeAdapter(TargetAdapter.class)
    private Target target;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

}