public abstract class Node<T, V> {
    protected V value;
    protected Node<T,V> parent;
    private List<T> children;

    public Node(V value){
        this.value = value;
        this.children = new ArrayList<T>();
    }

    public List<T> getChildren(){
        return this.children;
    }

    public void addChild(T child){
        this.children.add(child);
    }

    public V getVal(){
        return this.value;
    }
}