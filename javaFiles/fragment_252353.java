public static Node insert(int left,int right)
{
    int num=right-left+1;
    Node root=new Node(a[left+num/2]);
    if(num > 1) {
        root.left = insert(left,left+num/2-1);
        root.right = insert(left+num/2+1,right);
    }
    return root;
}