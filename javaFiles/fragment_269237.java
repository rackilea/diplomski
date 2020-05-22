public boolean equals(Object obj) {
    if (!(obj instanceof Triplet)) {
        return false;
    } else {
        Triplet that = (Triplet)obj;
        return this.curr.equals(that.curr) &&
            this.next.equals(that.next) &&
            this.prev.equals(that.prev);
    }
}

public int hashCode() {
    int hash = this.curr.hashCode();
    hash = hash * 31 + this.next.hashCode();
    hash = hash * 31 + this.prev.hashCode();
    return hash;
}