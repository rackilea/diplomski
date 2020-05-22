import java.io.*;
import java.util.*;

class Node {
int value;
int balancefactor;
int nodex;
Node left;
Node right;

Node(int value, int balancefactor, int nodex) {
    this.value = value;
    this.balancefactor = balancefactor;
    this.nodex = nodex;
    this.right = null;
    this.left = null;
}
}

public class treeStructureBinary{

Node root;

public static void main(String[] args) {
    treeStructureBinary bn =new treeStructureBinary();
    bn.appMain(args);
}
void appMain(String[] args) {
    int count = args.length;
    if (count >1) {
        count = 1;
    }
    String [] cmdln = {""};
    for (int i=0;i<count;i++) {
        cmdln[i]=args[i];
    }
    if (cmdln[0].equals("BT")){
        createBinaryTree();
    } else if (cmdln[0].equals("AVL")) {
    } else {
        System.out.println("Please enter BT or AVL to choose the type of 
tree.");
    }
}

private Node addRecursive(Node current, int value, int balancefactor, int 
nodex) {
    if (current == null) {
        return new Node(value, balancefactor, nodex);
    } if (value < current.value) {
        balancefactor++;
        nodex=(nodex*2);
        current.left = addRecursive(current.left, value, balancefactor, 
nodex);
    } else if (value > current.value) {
        balancefactor++;
        nodex=(nodex*2)+1;
        current.right = addRecursive(current.right, value, balancefactor, 
nodex);
    } else {
        return current;
    }
        return current;
}

public void add(int value) {
    int balancefactor=1;
    int nodex=0;
    this.root = addRecursive(this.root, value, balancefactor, nodex);
}

public treeStructureBinary createBinaryTree() {
    treeStructureBinary bt = new treeStructureBinary();
    int [] array = new int[89];
    int counter = 0;
    boolean check = true;
    int temp = 0;
    while (temp < 5) {
        Random rand = new Random();
        int n = rand.nextInt(89) + 10;
        for(int z = 0; z <= counter; z++) {
            if ( n == array[z]) {
                    check = false;
                    break;
            }
        }
        if (check == true) {
                bt.add(n);
                array[counter] = n;
                counter++;
        }
        check = true;
        temp = bt.treeDepth();
    }
    bt.traverseLevelOrder();
    Scanner reader =new Scanner(System.in);
    System.out.println("\n\nEnter a number to delete or 0 to exit");
    int input = reader.nextInt();
    Boolean isMatch = true;
    while (input!=0) {
        for(int p = 0; p < counter; p++)
        {
            //System.out.println(array[p]);
            if (input != array[p])
            {

                isMatch = false;
            }
            else
            {
                isMatch = true;
                array[p] = 0;
                break;
            }
        }
        if (isMatch == false )
        {
            System.out.println("Error, number not found.");
        }
        bt.nodeDelete(input);
        bt.traverseLevelOrder();
        System.out.println("\n\nEnter a number to delete or 0 to exit");
        input = reader.nextInt();
    }
    return bt;
}

public void traverseLevelOrder() {
    int count = 0;
    int outer = 31;
    int inner = 30;
    int lastnode= 0;
    int check = 0;
    if (this.root == null) {
        return;
    }

    Queue<Node> nodes = new LinkedList<>();
    nodes.add(this.root);

    while (!nodes.isEmpty()) {

        Node node = nodes.remove();
        if (count < node.balancefactor) {
            System.out.print("\n");
            for (int i=0; i<outer; i++) {
                System.out.print(" ");
            }
            inner=outer;
            outer=outer/2;
            count++;
            lastnode=0;
            check=0;
        }
        check=((node.nodex-lastnode));
        for (int i=0; i<(inner*check*2);i++) {
                System.out.print(" ");
        }
        if (check >1) {
            for (int j=0;j<check;j++) {
                System.out.print("  ");
            }
        }
        lastnode=node.nodex;
        System.out.print(node.value);

        if (node.left != null) {
            nodes.add(node.left);
        }
        if (node.right != null) {
            if (node.right==null &&lastnode == 0) {
                if (count==5) {
                    break;
                }
                System.out.print("  ");
            }
            nodes.add(node.right);
        }
    }
}

int treeDepth(){
    int temp = treeDepthRecursive(this.root);
    return temp;
}

int treeDepthRecursive(Node current) {
    if (current == null) {
        return 0;
    } else {
        int lDepth = treeDepthRecursive(current.left);
        int rDepth = treeDepthRecursive(current.right);
        if (lDepth > rDepth) {
            return (lDepth + 1);
        } else {
            return (rDepth + 1);
        }
    }
}

public void nodeDelete(int value) {
    nodeDeleteRecursive(root, value);
}

public Node nodeDeleteRecursive(Node current, int value) {
    if (current == null) {
        return null;
    }
    if (value == current.value) {
        if (current.left ==null && current.right==null) {
        return null;
        }
        if (current.right==null) {
            return current.left;
        }
        if (current.left==null) {
            return current.right;
        }
        int sValue = findSmall(current.right);
        current.value = sValue;
        current.right = nodeDeleteRecursive(current.right, sValue);
        return current;
    }
    if (value < current.value) {
        current.left = nodeDeleteRecursive(current.left, value);
        return current;
    }
    current.right =nodeDeleteRecursive(current.right, value);
    return current;
}

public int findSmall(Node root) {
    return root.left == null?(root.value):(findSmall(root.left));
}
}