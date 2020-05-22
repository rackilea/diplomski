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
    Abc other = (Abc) obj;
    if (!Arrays.equals(attributes, other.attributes)) {
        return false;
    }
    return true;
}