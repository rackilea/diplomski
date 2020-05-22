class BST {
    Node root;

    BST(){
        root=null;
    }

    public static void main(String[] args) { 
        BST tree = new BST(); 
        tree.root=tree.insert(tree.root,23); 
        tree.insert(tree.root,0); 
        tree.insert(tree.root,1); 
        tree.insert(tree.root,4); 
        tree.insert(tree.root,12); 
        tree.insert(tree.root,58); 
        tree.insert(tree.root,122); 
        tree.inorder(tree.root); 
    }

    Node insert(Node root, int data) { 
        if (root == null) { 
            root = new Node(data); 
            return root; 
        } 
        if (data < root.data) 
            root.left = insert(root.left, data); 
        else if (data > root.data) 
            root.right = insert(root.right, data); 
        return root; 
    } 

    void inorder(Node root) { 
        if (root != null) { 
            inorder(root.left); 
            System.out.println(root.data); 
            inorder(root.right); 
        } 
    } 
}