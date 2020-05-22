public boolean equals(Object obj) {
    if (obj instanceof ArrayTest) {
        ArrayTest o = (ArrayTest) obj;
        return o.i == this.i;
    }
    return false;
}