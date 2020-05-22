class Container<T> {

    public final T t;
    public final Class<T> ct;

    public Container(final T t, Class<T> ct) {
        this.t = t;
        this.ct = ct;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((ct == null) ? 0 : ct.hashCode());
        result = (prime * result) + ((t == null) ? 0 : t.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Container other = (Container) obj;
        if (ct == null) {
            if (other.ct != null)
                return false;
        } else if (!ct.equals(other.ct))
            return false;
        if (t == null) {
            if (other.t != null)
                return false;
        } else if (!t.equals(other.t))
            return false;
        return true;
    }

}