@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o == null || getClass() != o.getClass())
        return false;

    GeoName geoName = (GeoName) o;

    if (!country.equals(geoName.country))
        return false;
    return city.equals(geoName.city);
}

@Override
public int hashCode() {
    int result = country.hashCode();
    result = 31 * result + city.hashCode();
    return result;
}