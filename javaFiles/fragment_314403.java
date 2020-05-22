public boolean equals (Object other) {
    if (!(other instanceof Person))
        return false;
    Person op = (Person) other;
    return this.name.equals(op.name);
}

public int hashCode () {
    return name.hashCode();
}