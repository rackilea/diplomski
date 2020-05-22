(p1, p2) -> {
    if(p1.x == p2.x) {
        return p1.y.compareTo(p2.y);
    }
    return p1.x.compareTo(p2.x);
}