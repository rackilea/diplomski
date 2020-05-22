public static class ListNode<T extends Comparable<T>>
        implements Comparable<ListNode<T>>  {
    //contains a left and a right, as well as a data field
    public T data;
    public ListNode<T> previous,next;


    //construct
    public ListNode() {
        data = null;
        previous = null;
        next = null;
    }

    //previous to next
    public ListNode(T data) {
        this.data = data;
        previous = null;
        next = null;
    }

    public ListNode(T data,ListNode<T> n1) {
        this.data = data;
        previous = n1;
        next = null;
    }

    public ListNode(T data,ListNode<T> n1,ListNode<T> n2) {
        this.data = data;
        previous = n1;
        next = n2;
    }

    public void addNode(ListNode<T> n1) {
        //gotta check if my next is null
        ListNode<T> holder = null;
        if(this.next != null) {
            holder = this.next;
        }
        this.next = n1;
        n1.previous = this;
        n1.next = holder;
    }

    @Override
    public int compareTo(ListNode<T> n1) {
        return data.compareTo(n1.data);
    }

    public void printMe() {
        System.out.println(this.data);
    }
}