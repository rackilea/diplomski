@SuppressWarnings("serial")
public class LineCommandId implements Serializable {
    private Integer product;
    private Integer purchase;
    public Integer getProduct() {
        return product;
    }
    public void setProduct(Integer idproduct) {
        this.product = idproduct;
    }
    public Integer getPurchase() {
        return purchase;
    }
    public void setPurchase(Integer idpurchase) {
        this.purchase = idpurchase;
    }
    public boolean equals(Object foo) {
        if (foo == null || foo.getClass() != this.getClass())
            return false;
        LineCommandId src = (LineCommandId)foo;
        if ((this.getProduct() == src.getProduct()) &&
            (this.getPurchase() == src.getPurchase()))
            return true;
        return false;
    }
    public int hashCode() {
        // implement
        return someHashCode;
    }
}