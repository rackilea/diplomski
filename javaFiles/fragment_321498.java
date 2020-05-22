abstract class AbstractBinaryTree<T, TTree extends AbstractBinaryTree<T, TTree>> {
    TTree parent;
    TTree leftChild;
    TTree rightChild;
    T value;     
}