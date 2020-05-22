public class Node <T> implements NodeActionInterface
{
    // <T> data;
    T data;
//  ^ T is the data type...

    Node<T> leftTree;
    Node<T> rightTree;
//      ^  not really an errror, but you should use the generic here

    //public <T> Node(<T> data)
    public Node(T data)
//        ^ declared another T hiding the "outer" T
//              ^ again: data type is T
    {
        this.data = data;
    }
}