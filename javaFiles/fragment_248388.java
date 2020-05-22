@Override
public boolean equals(Object o) {
    return o instanceof Key
        && _lat.equals(((Key)o)._lat))
        && _lon.equals(((Key)o)._lon));
}

@Override
public int hashCode() {
    // String.hashCode() is sufficiently good for this addition to be acceptable
    return _lat.hashCode() + _lon.hashCode();
}