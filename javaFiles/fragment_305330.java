import java.util.ArrayList;
import java.util.List;

public class Tree {
    public Node root;

    public Tree(int kArity)
    {
        Node.maxNrOfChildren=kArity;        
    }

    public void addRoot(Object info)
    {
        root=new Node(info);
        root.parent=null;
        root.children=new ArrayList<Node>(Node.maxNrOfChildren);
    }

    public void addNewNodeVasithChildOfNodeU(Node u, Object info, int i)
    {
        Node child=new Node(info);
        u.addChild(child, i);
    }

    // I've made the above two methods of type void, not Node, because
    // I see no reason in returning anything; however, you can override by calling
    //'return root;' or 'return child;'

    public int numberOfNodesInTree(Node rootNode){
        int count=0;

        count++;
        if(rootNode.children.size()!=0) {
            for(Node ch : rootNode.children)
                count=count+numberOfNodesInTree(ch);
        }

        return count;
    }

    public int numberOfNodesInTree()
    {
        return numberOfNodesInTree(this.root);
    }

    public void changeRoot(Node newRoot, int i)
    {
        Node oldRoot=this.root;
        newRoot.parent=null;
        newRoot.addChild(oldRoot, i);
        oldRoot.parent=newRoot;
        this.root=newRoot;
    }

    public static void main(String args[])
    {
        Tree tree=new Tree(3);
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");

        tree.addRoot("root");
        tree.root.addChild(a,0);
        a.addChild(b,0);
        tree.root.addChild(c,1);
        System.out.println(tree.numberOfNodesInTree(tree.root));
    }
}