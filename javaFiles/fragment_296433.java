public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof ArrayTest)) return false;
    ArrayTest o = (ArrayTest) obj;
    return o.i == this.i;
}