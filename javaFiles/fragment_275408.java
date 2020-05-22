public static LinkedList additem(LinkedList l1,int item) //inserting an item in the linkedlist (this assigns old reference to the new items next)
{
LinkedList l2=new LinkedList(item,l1.next);
l1.next = l2;
return l1;

}

public static void traverse( LinkedList l1){
    do{
        System.out.println(l1.item);
        if(l1.next!=null){
            l1=l1.next;
        }
    }while(l1.next!=null);
     System.out.println(l1.item);
}

public static void main(String args[])
{
    LinkedList l1 = new LinkedList();
    LinkedList l2 = new LinkedList();
    LinkedList l3 = new LinkedList();
    LinkedList l4 = new LinkedList();
    l1.item = 3;
    l1.next = l2;
    l2.item = 5;
    l2.next = l3;   
    l3.item = 7;
    l3.next = l4;
    l4.item = 9;
    l4.next = null;

    //traverse(l1);

    l1=additem(l1,8); // inserting an item after l1 (so l1 points to the newly added value and the new one gets the nxt items refernce)
     traverse(l1);
}