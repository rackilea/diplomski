@Entity
public class B implements Serializable {

    private Integer id;

    private A a;

    public void setIdAsMutableInt(MutableInt id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(fetch=FetchType.LAZY)
    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

}