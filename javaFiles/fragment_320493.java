public class LinkedTest   // Realy want a circulare linked list or a normal linked list ???
{
    private MyNode head; // head node of the list (or null if empty)
    private MyNode tail; // last node of the list (or null if empty)
    private int size; // number of nodes in the list   

private class MyNode<>  // INNER class
{ 
    private String word; // reference to the element stored at this node
    private MyNode next; // reference to the subsequent node in the list

    public MyNode(String w, MyNode n) 
     { 
       word = w;
       next = n;
     } 
// The outer class has access to the variables of the inner
//     public String getWord( ) { return word; } 
//     public MyNode<String> getNext( ) { return next; } 
//     public void setNext(MyNode<String> n) { next = n; } 
} // end of inner class



public LinkedTest( ) { head = null; tail=null; size=0; } // constructor
public int size( ) { return size; } 
public boolean isEmpty( ) { return size == 0; } 
public MyNode getHead( ) { return head; }

public void addFirst(String w) 
{
    MyNode n = new MyNode(w,null);
     if (head == null)
     {  head = n; tail = n; 
     } else
     {
        //n.setNext(head);
        n.next = head;
        head = n;
     }
     size++;
} 
public void addLast(String w)
{
      MyNode n = new MyNode(w,null);
      if (tail != null)
      {   tail.next = n; // tail.setNext(w);
          tail = n;
      } else
      {  head = n;
         tail = n;
      }
      size++;
} 

 public String last( ) 
 { // returns (but does not remove) the last element
      return  tail == null ? null : tail.word;
 }

/**
 * Checks the linked list for at least one duplicate
 * @return true if a duplicte was found, false otherwise
 */
public boolean checkDuplicate() 
{
    String str;

    for (MyNode a = head;a != null; a = a.next)
    { 
         str = a.word;
         System.out.println("Examine node '" + str + "'");

         for (MyNode b = a.next;b != null;b = b.next) // scan the list behind 'a'
         {
             if (str.equals(b.word))
             {    
                 System.out.println("First duplicate is '" + str + "'");
                 return true;
             }
         }
    }
    return false;
} //---------------- checkDuplicate