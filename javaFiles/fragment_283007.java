@Entity
public class A implements Serializable {

    private MutableInt id = new MutableInt();

    private B b;

    public void setIdAsMutableInt(MutableInt id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id.intValue();
    }

    public void setId(Integer id) {
        this.id.setValue(id);
    }

    /**
      * Any ToOne annotation, such as @OneToOne and @ManyToOne, is EARGELY loaded, by default
      */
    @OneToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @Cascade(CascadeType.SAVE_UPDATE)
    public B getB() {
        return b;
    }

    public void setB(B b) {
        b.setIdAsMutableInt(id);

        this.b = b;
    }

}