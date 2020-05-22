public class LinkedList {

    static Node head;

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        for(int i = 0; i < 5; i++)

            list.add(i);

        Node currentNode = head; // in java we don't need object initialization for reference. Node temp1; would work just fine

        System.out.println("==head node== " + currentNode);
        while(currentNode.next != null) {

            // here we increment
            currentNode = currentNode.next;

//            System.out.println("Last time we in here, next is null so print only current");
            System.out.println("==next node== " + currentNode);
        }
    }

    void add(int value){
        Node newNode = new Node(value);

        if(head == null )//Very first time its create the head object when i = 0
        {
            head = newNode;
        }else if(head.next == null){//This is for when i value is 1
            head.next  = newNode;
        }else{ //else part execute i >= 2
            //Created new node with head.next which mean value 1.And head is 0
            Node temp = head.next;
            // Just need this object initialization for reference
            Node temp1 = newNode;
            //Checking head.next is null or not if its null skip this loop execution
            while(temp != null)
            {
                temp1 = temp;
                temp = temp.next;
            }
            // Here we set newNode.next to null
            System.out.println("  ==temp1== " + temp1);// before
            newNode.next = temp1.next;
            temp1.next = newNode;
            System.out.println("  ==temp1== " + temp1);// and after
        }

        System.out.println("==current node== " + head);
        System.out.println();
    }
}