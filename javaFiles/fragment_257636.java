public class DoReverse{ 
    private Node head; 
    private static class Node {
        private int value; 
        private Node next; 
        Node(int value) { 
            this.value = value; 
            } 
        } 
    public void addToTheLast(Node node) { 
        if (head == null) {
            head = node; 
        } 
        else { 
            Node temp = head;
            while (temp.next != null) 
                temp = temp.next; 
            temp.next = node; 
            } 
        } 
    public void printList(Node head) { 
        Node temp = head; 
        while (temp != null) { 
            System.out.format("%d ", temp.value); 
            temp = temp.next; 
            } 
        System.out.println(); 
        } 

    public static Node reverseList(Node head){

        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;

    }

    public static void main(String[] args) { 
        DoReverse list = new DoReverse(); 
        // Creating a linked list 
        Node head = new Node(5);
        list.addToTheLast(head); 
        list.addToTheLast(new Node(6)); 
        list.addToTheLast(new Node(7)); 
        list.addToTheLast(new Node(1)); 
        list.addToTheLast(new Node(2)); 
        list.addToTheLast(new Node(10));
        System.out.println("Before Reversing :");
        list.printList(head); 


        Node reverseHead= list.reverseList(head);
        System.out.println("After Reversing :");
        list.printList(reverseHead);


        } 
}