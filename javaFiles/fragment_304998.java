@Override
public int hashCode() {
    return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MyObj)) return false;

    MyObj myObj= (MyObj) obj;
    return Objects.equals(id, myObj.id);
}