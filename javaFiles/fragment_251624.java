public boolean equals(Object o) {
    if( !(o instanceof MyClass) ) return false;

    MyClass mc = (MyClass)o;
    if(this.someInt != mc.someInt)
        return false;
    return (this.someString == null)
            ? mc.someString == null
            : this.someString.equals(mc.someString);
}
public int hashCode() {
    int hashCode = someInt;
    if(someString != null)
        hashCode ^= someString.hashCode();
    return hashCode;
}