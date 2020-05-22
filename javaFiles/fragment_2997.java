public class BSTNode extends Node {
    private BSTNode left,right;
    private MovieInfo val;

    public void setVal(MovieInfo val){
        this.val=val;
    }

    public void setLeft(MovieInfo m){
        left=new BSTNode(m);
    }
    public void setRight(MovieInfo m){
        right=new BSTNode(m);
    }
    //override some of the Node methods
}