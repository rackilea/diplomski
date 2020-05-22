public class Triangle {

    private Set<Integer> nodes = new HashSet<Integer>();
    public Triangle(Node... node ) {
        for (Node node2 : node) {
            nodes.add(node2.getValue());
        }
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
        return result;
    }
    @Override
    public String toString() {
        return "Triangle [nodes=" + nodes + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Triangle other = (Triangle) obj;
        if (nodes == null) {
            if (other.nodes != null)
                return false;
        } else if (!nodes.equals(other.nodes))
            return false;
        return true;
    }
}