public boolean equals(Object other) {
    if (other == null) {
       return false;
    }
    if (!(other instanceof Test)) {
       return false;
    }
    return this.a == ((Test) other).a;
}