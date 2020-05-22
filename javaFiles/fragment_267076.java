public class FibonacciLinkedList extends LinkedList<Integer> {
    public FibonacciLinkedList(int n){
        int a = 0, b = 0, c = 1;
        for(int i = 1; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
            this.add(c);
        }
    }

    public void display() {
        System.out.println(this.toString());
    }

    public static void main(String[] args) {
        FibonacciLinkedList list = new FibonacciLinkedList(20);
        list.display();
    }
}