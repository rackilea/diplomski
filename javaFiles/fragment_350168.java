public NonEmptyBst<D> add(D elt) {
    if (data == elt) {
        return this;
    } else {
        if (elt.compareTo(data) < 0) {
            this.left = this.left.add(elt);
        } else {
            this.right = this.right.add(elt);
        }
    }

    return this;
}