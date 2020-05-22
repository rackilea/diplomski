public boolean equals(Object o){
    return o instanceof ClientID ? this.equals((ClientID) o);
}

public boolean equals(String otherID) {
    return id.equals(otherID);
}

public boolean equals(ClientID other) {
    return id.equals(other.id);
}