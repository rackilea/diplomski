import java.util.LinkedList;
import java.util.Queue;
public class BST {
Node root;
public BST(){
    root = null;
}

public void insert(int el){

    Node tmp = root, p=null;
    while(null!=tmp && el != tmp.data){
        p=tmp;
        if(el<tmp.data)
            tmp=tmp.left;
        else
            tmp=tmp.right;
    }
    if(tmp == null){
        if(null == p)
            root = new Node(el);
        else if(el <p.data)
            p.left= new Node(el);
        else
            p.right=new Node(el);
    }
}//

public void pathToSum(int sum) {
    pathToSum(root, sum);
}//

private boolean pathToSum(Node n, int sum) {
    if (null != n) {
        sum -= n.data;
        boolean found = pathToSum(n.left, sum);

        if (!found) {
            found = pathToSum(n.right, sum);
        }
        if (found) {
            System.out.println(n.data);
            return found;
        }
    }
    return 0 == sum ? true : false;
}

public static void main(String[] args){
    int[] input={50,25,75,10,35,60,100,5,20,30,45,55,70,90,102};
    BST bst = new BST();
    for(int i:input)
        bst.insert(i);
    bst.pathToSum(155);
}
}

class Node{
public int data;
public Node left;
public Node right;
public Node(int el){
    data = el;
}
}