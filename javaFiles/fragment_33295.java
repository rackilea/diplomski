class Wrapper implements Comparable<Wrapper> {

    public Foo foo;
    public Double distance;

    public Wrapper(Foo foo, Double distance) {
        this.foo = foo;
        this.distance = distance;
    }

    /**
     * Use only Foo for hashcode and equals 
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((foo == null) ? 0 : foo.hashCode());
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
        Wrapper other = (Wrapper) obj;
        if (foo == null) {
            if (other.foo != null)
                return false;
        } else if (!foo.equals(other.foo))
            return false;
        return true;
    }

    @Override
    public int compareTo(Wrapper o) {
        return distance.compareTo(o.distance);
    }

}@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Wrapper other = (Wrapper) obj;
    if (foo == null) {
        if (other.foo != null)
            return false;
    } else if (!foo.equals(other.foo))
        return false;
    return true;
}

@Override
public int compareTo(Wrapper o) {
    return distance.compareTo(o.distance);
}

}