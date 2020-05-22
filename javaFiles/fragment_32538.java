@Override
public boolean equals(Object o) {

    if (o == this) return true;
    if (!(o instanceof Emp)) {
        return false;
    }
    Emp emp = (Emp) o;
    return  Objects.equals(city, emp.city) &&
            Objects.equals(name, emp.name);
}