@Override
public int hashCode() {
    return toString().hashCode();
}

@Override
public boolean equals(Object obj) {
    return this == obj || obj != null && getClass() == obj.getClass() && toString().equals(obj.toString());
}