@Table(name="child_model")
@javax.persistence.Entity
public class ChildModel extends GenericModel<ChildModel> {

    @Column
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}