@Override
public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }

    Employee other= (Employee)obj;
    if (!this.name.equals(other.name)) {
        return false;
    }

    return true;

}

@Override
public int hashCode() {
    //your hashcode logic goes here
}