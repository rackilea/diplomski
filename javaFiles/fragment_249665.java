@Override
public int hashCode() {
    int hash = 3;       
    hash = 53 * hash
            + ((effectiveTime == null) ? 0 : effectiveTime.hashCode());
    hash = 53 * hash + ((id == null) ? 0 : id.hashCode());
    return hash;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    final ConceptPK other = (ConceptPK) obj;
    if (effectiveTime == null) {
        if (other.effectiveTime != null)
            return false;
    } else if (!effectiveTime.equals(other.effectiveTime))
        return false;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    return true;
}