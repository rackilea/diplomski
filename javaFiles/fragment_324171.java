@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((placeId == null) ? 0 : placeId.hashCode());
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    PlacesInfo other = (PlacesInfo) obj;
    if (placeId == null) {
        if (other.placeId != null)
            return false;
    } else if (!placeId.equals(other.placeId))
        return false;
    return true;
}