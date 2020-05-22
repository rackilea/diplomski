public class Node {
    public HashMap<Key, Node> map;
    public Data<T> data;
    public Key key;
    public Node parent;
    public void update() {
        if (parent != null) parent.map.remove(key);
        key.update(data);
        if (parent != null) parent.map.put(key, this);
    }
}

public abstract class Key {
    public abstract void update(Data data);
    public abstract int hashCode();
    public abstract boolean equals(Object obj);
}

public class MyKey extends Key {

    private Object value = null;

    public final void update(Data data) {
        value = data.value;
    }

    public final boolean equals(Object obj) {
        IdentityKey that = (IdentityKey)obj;
        return this.value == that.value;
    }

    public final int hashCode() {
        return value == null ? 0 : value.hashCode();
    }
}