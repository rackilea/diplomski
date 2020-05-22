public static void main(String[] args)
{

    ExpTree tree = new ExpTree('*', 1 , 2);
    System.out.println(tree.preOrder());

}

//Class Exp Tree creates Expression Tree with method to generate pre order output.

package ExpTree;


public class ExpTree {

    public Node root;

    public ExpTree ( char x, int y, int z){

        this.root = new OperatorNode(x, y, z);
    }

    public String preOrder (){

        return root.preOrder();
    }

}

abstract class Node {
    public abstract String preOrder();
}

class OperatorNode extends Node {

    char operator;
    Node left;
    Node right;

    public OperatorNode(char x, int y, int z){

        this.operator = x;
        this.left = new leafNode (y);
        this.right = new leafNode (z);
    }

    public String preOrder() {
        return this.operator + this.left.preOrder() + this.right.preOrder();
    }

}

class leafNode extends Node{
    int value;

    public leafNode(int x){
         this.value = x;
    }

    public String preOrder() {
        return Integer.toString(this.value);
    }
}