private transient Map<T, U> map1 = null;
public Map<T, U> likeValues() {
    Map<T, U> m = this.map1;
    if (m == null) {
        m = new HashMap<T, U>();
        this.map1 = m;
    }
    return m;
}

private transient Map<T, U> map2 = null;
public Map<T, U> usingField() {
    if (this.map2 == null) {
        this.map2 = new HashMap<T, U>();
    }
    return this.map2;
}