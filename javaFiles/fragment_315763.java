public class Element<C extends Element<C>> {
    List<C> children;
    Element<C> parent = null;

    public Element() {
    }

    void setChildren(List<C> children) {
        this.children = children;
        for (C c : children) {
            c.setParent(this);
        }
    }

    void setParent(Element<C> parent) {
        this.parent = parent;
    }
}