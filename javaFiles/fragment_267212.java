...
public boolean equals(Object other) {
    if (this == other) return true;
    if ( !(other instanceof Cat) ) return false;

    final Cat cat = (Cat) other;

    if ( !cat.getLitterId().equals( getLitterId() ) ) return false;
    if ( !cat.getMother().equals( getMother() ) ) return false;

    return true;
}

public int hashCode() {
    int result;
    result = getMother().hashCode();
    result = 29 * result + getLitterId();
    return result;
}