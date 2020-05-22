public class LinkedList{

    public static void main(String[] args) {
    LinkedList node0 = new LinkedList(0);
    LinkedList node1 = new LinkedList(1);
    LinkedList node2 = new LinkedList(2);
    LinkedList node3 = new LinkedList(3);
    LinkedList node4 = new LinkedList(4);
    LinkedList node5 = new LinkedList(5);
    LinkedList node6 = new LinkedList(6);
    LinkedList node7 = new LinkedList(7);
    LinkedList node8 = new LinkedList(8);
    node0.setNext(node1);
    node1.setNext(node2);
    node2.setNext(node3);
    node3.setNext(node4);
    node4.setNext(node5);
    node5.setNext(node6);
    node6.setNext(node7);
    node7.setNext(node8);

    node0.removeOddFromVale(3, false);
    System.out.println();
    }

    public void removeOddFromVale(int value,boolean start){
    LinkedList head = this;
    LinkedList prev = this;

    if(!start){
        while(head != null){
        if(head.value == value){
            start = true;
            break;
        }
        prev = head;
        head = head.next;
        }
    }

    if(prev != null && head != null){
        if(prev == head){
        head = head.next;
        }

        if (head != null) {
        if (head.value % 2 == 0) {
            prev.next = head.next;
        } else {
            prev = prev.next;
            head = head.next;
        }
        if (prev != null) {
            prev.removeOddFromVale(value, true);
        }
        }
    }

    }

    private LinkedList next;
    private int value;

    public LinkedList(int value){
    this.value = value;
    }

    public LinkedList getNext() {
        return next;
    }
    public void setNext(LinkedList next) {
        this.next = next;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}