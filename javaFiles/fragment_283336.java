@Override
public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;
    final Man man = (Man) o;
    return Objects.equals(this.name, man.name);
}

@Override
public int hashCode() {
    return Objects.hash(this.name);
}