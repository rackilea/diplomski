@Override
public boolean equals(Object obj) {
    if (obj == null)
        return false;
    if (!(obj instanceof Boat))
        return false;

    Boat b = (Boat)obj;
    return  b.someproperty==this.someproperty;//Assuming someproperty is primitive
}