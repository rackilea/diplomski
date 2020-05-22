public Point initalBid() {
    if (producer.size() > 0) {
        return producer.get(0);
    }
    return null;
}