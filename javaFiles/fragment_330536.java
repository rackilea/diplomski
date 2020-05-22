private static class Node implements Comparable<Node> {

    public int id; // 0 indexed
    public int distFromS;

    Node(int id, int distFromS) {
        this.id = id;
        this.distFromS = distFromS;
    }

    @Override
    public int compareTo(Node another) {
        // your codes here
    }
}