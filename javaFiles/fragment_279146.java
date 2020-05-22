public class main {

    public static Node<Integer> change(Node<Integer> first)
    {
        return new Node<Integer>(12,first);
    }
    public static void main(String[] args) {
        Node<Integer> first = new Node<Integer>(1);
        first = new Node<Integer>(2,first);
        first = new Node<Integer>(3,first);
        Node <Integer>pos = first;
        while (pos!=null){
            System.out.print(pos.getInfo()+"->");
            pos = pos.getNext();
        }
        System.out.println();
        pos = change(first);
        while (pos!=null){
            System.out.print(pos.getInfo()+"->");
            pos = pos.getNext();
        }

    }

}