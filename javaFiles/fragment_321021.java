import java.io.*;

class Node
{
public Node previous;
public String value;
public Node next;
}

public class LinkedList
{
private BufferedReader br ;
private String str; 
private int totalNodes;

private  Node current, previous, temp, head, tail; 

public LinkedList()
{
    br = new BufferedReader(new InputStreamReader(System.in));
    current = previous = temp = head = tail = null;
    totalNodes = 0;
}

public static void main(String[] args)
{
    LinkedList ll = new LinkedList();
    ll.menu();
}

private void menu()
{
    boolean flag = true;
    int choice = 0;
    while(flag)
    {
        System.out.println("--------------------------------------------------");
        System.out.println("---------------------MENU-----------------------");
        System.out.println("Press 1 : To ADD Node at the END.");
        System.out.println("Press 2 : To ADD Node at the BEGINNING.");
        System.out.println("Press 3 : To Add Node in BETWEEN    the List.");
        System.out.println("Press 4 : To  SORT the List");
        System.out.println("Press 5 : To DISPLAY the List.");
        System.out.println("Press 6 : To EXIT the Program.");
        System.out.println("--------------------------------------------------");
        System.out.print("Please Enter your choice here : ");
        try
        {
            str = br.readLine();
            choice = Integer.parseInt(str);
            if (choice == 6)
            {
                flag = false;
            }
            accept(choice);
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("OUCH!, Number Format Exception, entotalNodesered.");
            nfe.printStackTrace();
        }
        catch(IOException ioe)
        {
            System.out.println("OUCH!, IOException, entotalNodesered.");
            ioe.printStackTrace();

        }
    }
}

private void accept(int choice)
{
    switch(choice)
    {
        case 1:
            addNodeToListAtStart();
            break;
        case 4:
            sortListBubble();
            break;
        case 5: 
            displayList();
            break;
        case 6:
            System.out.println("Program is Exiting.");
            break;
        default:
            System.out.println("Invalid Choice.\nPlease Refer Menu for further Assistance.");
    }
}   

private void addNodeToListAtStart()
{
    if (head != null)
    {
        current = new Node();
        System.out.print("Enter value for the New Node : ");
        try
        {
            str = br.readLine();
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("OUCH!, Number Format Exception, entotalNodesered.");
            nfe.printStackTrace();
        }
        catch(IOException ioe)
        {
            System.out.println("OUCH!, IOException, entotalNodesered.");
            ioe.printStackTrace();              
        }
        current.previous = tail;
        current.value = str;
        current.next = null;
        tail.next = current;
        tail = current;
    }
    else if (head == null)
    {
        current = new Node();
        System.out.print("Enter value for the New Node : ");
        try
        {
            str = br.readLine();
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("OUCH!, Number Format Exception, entotalNodesered.");
            nfe.printStackTrace();
        }
        catch(IOException ioe)
        {
            System.out.println("OUCH!, IOException, entotalNodesered.");
            ioe.printStackTrace();              
        }
        current.previous = null;
        current.value = str;
        current.next = null;            
        head = current;
        tail = current;
    }
    totalNodes++;
}

private void displayList()
{
    current = head;
    System.out.println("----------DISPLAYING THE CONTENTS OF THE LINKED LIST---------");
    while (current != null)
    {
        System.out.println("******************************************");
        System.out.println("Node ADDRESS is : " + current);
        System.out.println("PREVIOUS Node is at : " + current.previous);
        System.out.println("VALUE in the Node is : " + current.value);
        System.out.println("NEXT Node is at : " + current.next);
        System.out.println("******************************************");
        current = current.next;
    }
}

private boolean sortListBubble()
{
    // For Example Say our List is 5, 3, 1, 2, 4
    Node node1 = null, node2 = null; // These will act as reference. for the loop to continue
    temp = head;    // temp is set to the first node.   

    if (temp == tail || temp == null)
        return false;

    current = temp.next; // current has been set to second node.

    for (int i = 0; i < totalNodes; i++) // this loop will  run till whole list is not sorted.
    {
        temp = head; // temp will point to the first element of the list.
        while (temp != tail) // till temp won't reach the second last, as it reaches the last element loop will stop.
        {
            if (temp != null)
                current = temp.next;
            while (current != null) // till current is not null.
            {
                int result = (temp.value).compareToIgnoreCase(current.value); 
                if (result > 0) // if elment on right side is higher in value then swap.
                {
                    if (temp != head && current != tail) // if nodes are between the list.
                    {
                        current.previous = temp.previous;
                        (temp.previous).next = current;
                        temp.next = current.next;
                        (current.next).previous = temp;                     
                        current.next = temp;
                        temp.previous = current;
                    }
                    else if (current == tail) // if nodes to be swapped are second last and last(current)
                    {
                        temp.next = current.next;
                        current.previous = temp.previous;
                        if (temp.previous != null)
                            (temp.previous).next = current;
                        else
                            head = current;
                        temp.previous = current;
                        current.next = temp;
                        tail = temp;
                    }
                    else if (temp == head) // if the first two nodes are being swapped.
                    {
                        temp.next = current.next;                       
                        (current.next).previous = temp;
                        current.previous = temp.previous;
                        temp.previous = current;
                        current.next = temp;
                        head = current;
                    }   
                    current = temp.next; // since swapping took place, current went to the left of temp, that's why
                                                   // again to bring it on the right side of temp.
                }
                else if (result <= 0) // if no swapping is to take place, then this thing
                {
                    temp = current;  // temp will move one place forward
                    current = current.next; // current will move one place forward
                }                                       
            }
            if (temp != null)
                temp = temp.next;
            else // if temp reaches the tail, so it will be null, hence changing it manually to tail to break the loop.
                temp = tail;
        }
    }
    return true;
}
}