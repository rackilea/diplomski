class Group<T extends Group<T, R>, R extends Comparable<R>> implements Comparable<T> {
    String id;

    public Group(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(T o) {
        return id.compareTo(o.id);
    }
}

class InnerGroup extends Group<InnerGroup, Integer> {
    public InnerGroup(String id) {
        super(id);
    }
}

class OuterGroup extends Group<OuterGroup, InnerGroup> {
    public OuterGroup(String id) {
        super(id);
    }
}