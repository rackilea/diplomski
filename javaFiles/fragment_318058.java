@Override
public boolean equals(Object obj) {
    if (!(obj instanceof Student))
        return false;
    if (obj == this)
        return true;
    return this.id == ((Student) obj).id;
}