public class Node {
    private Board board;
    private Node[] childs;

    public Node(Board b, int nbChilds){
        this.board = new Board(b);
        this.childs = new Node[nbChilds];
    }

    public Node getChildAt(int i){
        return childs[i];
    }

    public int nbChilds(){
        return childs.length;
    }

    public void setChildAt(int i, Node n){
        this.childs[i] = n;
    }

    public Board getBoard(){
        return this.board;
    }