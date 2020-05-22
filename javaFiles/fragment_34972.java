private int compareDistances(Node n1, Node n2) {
    int distance1 = this.distanceBetween(parent, n1);
    int distance2 = this.distanceBetween(parent, n2);

    return distance2 - distance1; // negative if n1 closer than n2
}