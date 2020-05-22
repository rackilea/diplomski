@Override
public boolean equals(Object o) {
    if (this == o) {
        return true;
    }else if (o instanceof MyClass) {
        // some will argue that the line above should have a
        // .getClass() check instead of an instanceof check.
        // those people also need to read Effective Java :-)
        MyClass that = (MyClass) o;
        return Objects.equals(this.classA, that.classA)
            && Objects.equals(this.classB, that.classB)
    } else {
        return false;
    } 
}

@Override
public int hashCode() {
    return Objects.hash(classA, classB);
}