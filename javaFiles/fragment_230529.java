class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node n1, Node n2) {
        return n1.regPlate.compareTo(n2.regPlate);
    }
}