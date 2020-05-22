public class Child {

    @XmlAnyElement
    private String child;

    public Child() {
    }

    public void setChild(String child) {
        this.child = child;
    }
    public String getChild() {
        return child;
    }
}