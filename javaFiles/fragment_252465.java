int findMax() {
    if (this.next == null) {
        return this.value;
    } else {
        return Math.max(this.value, this.next.findMax());
    }
}