class Node<T extends Node<T>> {
    public Iterator<T> iterator(){
        // basic tree traversal iterator
    }  
}

class IntegerNode extends Node<IntegerNode> {
    public static void main(String[]args) {
        IntegerNode root = new IntegerNode();
        int total = 0;
        for(IntegerNode child : root){  
            total += child.value;
        }

        System.out.println(total);
    }
}