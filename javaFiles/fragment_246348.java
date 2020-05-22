public class Node {
    private String data;
    private int row,col;
    private Node parent;
    public Node(Node parent,int row,int col) {
        this.parent = parent;
        this.col = col;
        this.row = row;
    }
    public boolean hasParent(int row, int col) {
        Node current = this;
        while((current=current.parent)!=null) {
            if(current.row == row && current.col==col)
                return true;
        }
        return false;
    }

    public String toString() {
        Node current = this;
        StringBuffer sb = new StringBuffer();
        do {
            sb.append(current.data);
        }while((current = current.parent)!=null);
        return sb.reverse().toString();
    }
}