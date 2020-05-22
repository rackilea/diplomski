public static void main( String[] args ) 
{
   LinkedListTest llt = new LinkedListTest();

   llt.insert(1);
   llt.insert(2);
   llt.insert(3);

   llt.printList();
   System.out.println();

   llt.delete(2);
   llt.printList();
}