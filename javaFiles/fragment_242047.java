public class Parent {
    ...
    public void addChild(Child child) {
        this.getChildren.add(child);
        child.setParent(this);
    }

    public void removeChild(Child child) {
        this.getChildren.remove(child);
        child.setParent(null);
    }