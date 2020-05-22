@Entity
public class A implements Serializable {

    private Integer id;

    private B b;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
      * mappedBy="a" means: Look at "a" field / property at B Entity. If it has any assigned value, join us Through B_ID foreign key column
      */
    @OneToOne(fetch=FetchType.LAZY, mappedBy="a")
    /**
      * Table A has a foreign key column called "B_ID"
      */ 
    @JoinColumn(name="B_ID")
    @Cascade(CascadeType.SAVE_UPDATE)
    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

}