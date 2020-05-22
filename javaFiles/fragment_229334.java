@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ImageEntity that = (ImageEntity) o;

    if (city != null ? !city.equals(that.city) : that.city != null) return false;

    return true;
}