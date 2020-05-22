import java.util.*; 
import java.lang.*; 
import java.io.*;

class Playground {
    public static void main(String[ ] args) {
        LinkedList list = new LinkedList();
        list.insertFirst("Robert", "Rodriguez", "RB123");
        list.insertFirst("Andrew", "Andrews", "AB123");
        list.insertFirst("Thomas", "Thomson", "TB123");

        System.out.println(list); // Prints unordered list, opposite order as they were introduced, since they were introduced from the beggining of the list.

        LinkedList sorted = sortList(list);
        System.out.println("\n"+sorted);
    }

    private static LinkedList sortList(LinkedList list) {
        // I use an ArrayList so I can just use Collections.sort
        LinkedList sortedList = new LinkedList();
        Node current = list.head;
        ArrayList<Node> array = new ArrayList<Node>();

        while (current != null) {
            array.add(current);
            current = current.link;
        }
        System.out.println("\nTemp Array:");
        System.out.println(array);

        array.sort(new NodeComparator());

        System.out.println("\nTemp Array (now sorted):");
        System.out.println(array);

        for (int i = array.size()-1; i >= 0; i--) {
            sortedList.insertFirst(array.get(i));
        }

        return sortedList;
    }
}

class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node n1, Node n2) {
        return n1.regPlate.compareTo(n2.regPlate);
    }
}

class Node {
    //data fields
    public String regPlate; // Registration Plate
    public String firstName;
    public String lastName;

    //refrence link
    public Node link;

    //default constructor
    public Node()
    {
        regPlate = "";
        firstName = "";
        lastName = "";
    }//end of constructor.

    public String toString() {
        return this.regPlate;
    }



}//end of node class

class LinkedList {

    Node head;
    Node tail;
    Node current;
    int listLength;

    //default constructor
    public LinkedList () 
    {
        head = null;
        listLength = 0;
    }

    //inserting new node in the beginning of the list
    public void insertFirst(String fN, String lN, String rP)
    {

        Node newNode = new Node();
        newNode.firstName = fN;
        newNode.lastName = lN;
        newNode.regPlate = rP;

        insertFirst(newNode);
    }//end of insertFirst

    public void insertFirst(Node newNode) {
        //make newNode point to the first node in the life
        newNode.link = head;

        //makes head point to the new first node
        head = newNode;

        if(head.link == null)
            tail = newNode;

        ++listLength;
    }

    public void displayDataLog()
    {
        Node current;

        current = head;

        while(current != null)
        {
            System.out.print("\n FullName: " + current.firstName + " " + current.lastName +
                            "\n Registration Plate Number: " + current.regPlate);

            current = current.link;
        }

    }//end of display vehicles

    public void totalVehicles()
    {
        System.out.print("\n Total Vehicle on the campus: " + listLength);
    }//end of total vehicles

    public String toString() {
        String str = "List:\nhead -> [ ";
        Node current = head;

        while (current != null) {
            str = str + current + (current == tail ? " ] <- tail" : ", ");
            current = current.link;
        }

        return str;
    }

}//end of linked list