@Override
public int hashCode() {
    int hash = 5;
    hash = 83 * hash + this.codigo;
    return hash;
}

@Override
public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final Modelo other = (Modelo) obj;
    if (this.codigo != other.codigo) {
        return false;
    }
    return true;
}