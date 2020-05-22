@Override
public int hashCode() {
    int hash = 3;
    hash = 53 * hash + Objects.hashCode(this.name);
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
    final Pet other = (Pet) obj;
    if (!Objects.equals(this.name, other.name)) {
        return false;
    }
    return true;
}