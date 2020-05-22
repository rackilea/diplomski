class DynamicArrayOfInts {
    private Node head, current; 
    private int numOfElementsPerNode;

    public DynamicArrayOfInts(int elementsPerNode) {
        if(elementsPerNode <= 0) 
            throw new IllegalArgumentException("elementsPerNode must be > 0");
        numOfElementsPerNode = elementsPerNode;
    }

    public void add(int e) {
        if(head == null){
            head = new Node(numOfElementsPerNode, null);
            head.data[head.index++] = e;
            current = head;
            return;
        }
        if(current.index == numOfElementsPerNode){
            Node n = new Node(numOfElementsPerNode, null);
            current.next = n;
            current = n;
        }
        current.data[current.index++] = e;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node n = head;
        while(n != null){
            sb.append(Arrays.toString(n.data));
            n = n.next;
        }
        return sb.toString();
    }

    private static class Node {
        private int[] data;
        private int index;
        private Node next;

        public Node(int n, Node nxt) {
            data = new int[n];
            index = 0;
            next = nxt;
        }
    }
}