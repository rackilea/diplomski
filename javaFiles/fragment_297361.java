class AbstractComponent {

    public Iterator<AbstractComponent> iterator() {
        List<AbstractComponent> list = new LinkedList<AbstractComponent>();
        addAllChildren(list);
        list.add(this);
        return list.iterator();
    }

    protected abstract void addAllChildren(List<AbstractComponent> list);
}

public class Leaf extends AbstractComponent {

    //...

    protected void addAllChildren(List<AbstractComponent> list) {
        //DO NOTHING
    }
}

public class Composite extends AbstractComponent {

    //...

    protected void addAllChildren(List<AbstractComponent> list) {
        for (AbstractComponent component : children) {
            // This is where you implement your traversal strategy
            component.addAllChildren(list);
            list.add(component);
        }
    }
}