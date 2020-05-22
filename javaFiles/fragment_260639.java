public static Node oddPosition( iNode x){
int count = 1;
iNode oddList = null;
iNode startOfList = null;
 for(Node temp = h; temp != null; temp = temp.next){
    if(count % 2 != 0 ){//<-----declares whether the position is odd or not
        //if oddList is empty
        if(oddList == null){
            oddList = new Node(temp.item);
            startOfList = oddList;
            oddList.next = null;
        } 
        //if oddList is not empty
        oddList.next = new Node(temp.item);
        oddList.next.next = null;
        oddList = oddList.next;
      }
    count++;
    }
  System.out.print("Odd list : ");
  print(startOfList);
  return startOfList;
}