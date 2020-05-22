public boolean equals(Object other) {
    return other instanceof Role && id != null ? id.equals(((Role) other).id) : other == this;
}

public int hashCode() {
    return id != null ? getClass().hashCode() + id.hashCode() : super.hashCode();
}