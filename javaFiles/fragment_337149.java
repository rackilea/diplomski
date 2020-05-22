@XStreamAlias("Product")
public class OtherProduct {

    @XStreamAlias("Id")
    private int id;

    public OtherProduct() {

    }

    public OtherProduct(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}