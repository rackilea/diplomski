class Node {
    static int i;
    int distance;

    Node(int i, int distance) {
        this.i = i;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return Integer.toString(distance); // Change as per your needs
    }

}