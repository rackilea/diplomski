static void reversePrint(SinglyLinkedListNode head) { 
    List tempList = null;

    if (head == null)
        return;
    else{
        tempList = new ArrayList<Integer>();
        while(head.next != null) {
            tempList.add(head.data);
            head = head.next;
        }
    }
    tempList.add(head.data);
    System.out.println("Size of the List -"+tempList.size());
    for(int i = tempList.size()-1;i>=0;i--)
        System.out.println("Index +"+i+" "+tempList.get(i));   

}