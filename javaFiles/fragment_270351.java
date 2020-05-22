@MappedSuperclass
public abstract class BaseEntity {
    @Id @GeneratedValue
    private Long id;

    @Version
    private long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}

@Entity
@Table(name = "portada")
public class Portada extends BaseEntity {
    //...other attributes
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "hito")
    private Hito hito;

    //...getters and setters from other attributes
    public Hito getHito() {return hito;}

    public void setHito(Hito hito) {this.hito = hito;}

}

@Entity
@Table(name = "hito")
public class Hito extends BaseEntity implements Serializable {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "hito")
    private Portada portada;


    public Portada getPortada(){ return portada;}

    public void setPortada(Portada portada){ this.portada = portada;}
}

// app:

            Portada p = new Portada();
            Hito h = new Hito();

            p.setHito(h);
            h.setPortada(p);

            entityManager.persist(h);
            entityManager.flush();
            entityManager.clear();

            Hito h2 = entityManager.find(Hito.class, h.getId());
            System.out.println(h2.getPortada().toString());

            tx.commit();