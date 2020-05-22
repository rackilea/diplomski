@Entity
public class B implements Serializable {

    private MutableInt id = new MutableInt();

    private A a;

    public void setIdAsMutableInt(MutableInt id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id.intValue();
    }

    public void setId(Integer id) {
        this.id.setValue(id);
    }

    @OneToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

}