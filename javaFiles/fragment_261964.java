@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Property)) return false;
    Property prop = (Property) o;
    return Objects.equals(id, prop.id);
}

@Override
public int hashCode() {
    return Objects.hash(id);
}