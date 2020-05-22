import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(ABid.class)
public class AB {
    @Id
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private A a;

    @Id
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private B b;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    // Getters and setters...
}