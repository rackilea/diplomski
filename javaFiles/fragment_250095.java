@Entity
@Table(name = "mybeans")
public class MyEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private MyBean myBean;

    @EmbeddedId
    @AttributeOverride(name="myValue", @Column(name="mybean_id"))
    public MyBean getMyBean() {
        return myBean;
    }

    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }

}