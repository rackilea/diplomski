public B clone() {
    try {
        return (B) super.clone();
    } catch (CloneNotSupportedException e) {
        throw new IllegalStateException(e);
    }
}