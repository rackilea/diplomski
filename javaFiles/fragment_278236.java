public class BinaryTree<E> {
    E data;

    BinaryTree<E> left, right;

    public void doubleEachElement() {
        BinaryTree temp = this;
        if (temp != null) {
            if (temp.data != null) {
                temp.setData(String.valueOf(Integer.parseInt(temp.getData().toString()) * 2));
            }
            this.left.doubleEachElement();
            this.right.doubleEachElement();
        }
    }

    // private void setData(String valueOf) {// This would throw an error
    // stating the String cannot be converted to E
    // data = valueOf;
    // }
    public void setData(E valueOf) {
        data = valueOf;
    }

    public E getData() {
        return data;
    }

    public void printBTreeInorder() {
        BinaryTree temp = this;
        if (this != null) {
            System.out.println(data);
        }
        if (this.left != null)
            this.left.printBTreeInorder();
        if (this.right != null)
            this.right.printBTreeInorder();
    }

    public static void main(String[] args) {
        BinaryTree<Integer> intBTree = new BinaryTree<>();
        intBTree.setData(3);
        intBTree.printBTreeInorder();
        intBTree.doubleEachElement();
        intBTree.printBTreeInorder();
    }
}