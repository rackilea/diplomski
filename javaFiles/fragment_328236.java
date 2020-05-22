@Override
public int hashCode() {
    return x;
}

@Override
public boolean equals(Object o) {
    return this == o || (o != null && getClass() == o.getClass() && x == ((Foo) o).x);
}

@Override
public int compareTo(Foo o) {
    return Integer.compare(x, o.x);
}