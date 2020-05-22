public class ParentEntity {
    ...
    public void addChild(ChildEntity c) {
        children.add(c);
        c.setParent(this);
    }
}