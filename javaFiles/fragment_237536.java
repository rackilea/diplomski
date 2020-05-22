@Override
public int hashCode() {
    int hash = 3;
    hash = 83 * hash + this.id;
    hash = 83 * hash + Objects.hashCode(this.email);
    hash = 83 * hash + Objects.hashCode(this.password);
    return hash;
}

@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final AppDataRequest other = (AppDataRequest) obj;
    if (this.id != other.id) {
        return false;
    }
    if (!Objects.equals(this.email, other.email)) {
        return false;
    }
    if (!Objects.equals(this.password, other.password)) {
        return false;
    }
    return true;
}