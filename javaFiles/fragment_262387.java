import java.util.*;

public class stackReversal {

    private class Node {
        private String item;
        private Node next;
       // private Node prev;
    }

    private Node first = null;

    public boolean isEmpty() {
        return (first == null);
    }

    public void push(String s) {
        Node node = new Node();
        node.item = s;
        node.next = first;

        first = node;
    }

    public String pop() {
        if (first == null)
            throw new RuntimeException("Stack Empty!");
        String result = first.item;
        first = first.next;
        return result;

    }

    public String popString() {
        String result = "";
        Node current = first;

        while (current != null) {
            result += current.item;
            current = current.next;
        }
        return result;
    }

    public String toString() {

        StringBuilder nodes = new StringBuilder();

        Node node = first;



        while (node != null) {
            nodes.append(node.item).append("\n");
            node = node.next;
        }

        if(isEmpty()) {
            return "";
        } else {
            return nodes.toString().substring(0, nodes.toString().length());
        }
    }
    class Queue{
        Node first, last;

        public void enqueue(String s){
            Node node = new Node();
            node.item = s;
            node.next = first;

            first = node;
        }

        public Node dequeue(){
            if(first == null){
                return null;
            }else{
                Node temp = new Node();//Node temp = new Node();
                first = first.next;
                return temp;
            }
        }
        public String toString() {

            StringBuilder nodes = new StringBuilder();

            Node node = first;

            while (node != null) {
                // Insert the current item at the beginning of the String
                nodes.insert(0, String.format("%s%n", node.item));
                node = node.next;
            }



            if(isEmpty()) {
                return "";
            } else {
                return nodes.toString().substring(0, nodes.toString().length());
            }
        }

    }


    public static void main(String[] args)
    {
        stackReversal s = new stackReversal();
        Queue q = s.new Queue();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter strings:");
        String in = input.nextLine();
        while (!in.equals("end-of-input"))
        {

            if (in.equals("end-of-input"))
                break;
            else
                q.enqueue(in);
                s.push(in);
            in = input.nextLine();
        }


        System.out.println("Strings:"+"\n" + s);
        System.out.println("Strings:"+"\n" + q);
    }
}