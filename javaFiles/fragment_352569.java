public BT randomNode() {
    int r = new Random().nextInt(this.size());
    if (r == 0) {
        return this;
    } else if (left != null && 1 <= r && r <= left.size()) {
        return left.randomNode();
    } else {
        return right.randomNode();
    }
}