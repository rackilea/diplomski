@Override
public boolean equals(Object o){
    if(!(o instanceof CarBean)) // also this already evaluates
        return false;           // to false if o is null

    CarBean other = (CarBean) o;
    if(brand == null ? other.brand != null : !brand.equals(other.brand))
        return false;
    if(color == null ? other.color != null : !color.equals(other.color))
        return false;

    return true;
}

@Override
public int hashCode() {
    int hash = 17;
    hash = 31 * hash + (brand == null ? 0 : brand.hashCode());
    hash = 31 * hash + (color == null ? 0 : color.hashCode());
    return hash;
}