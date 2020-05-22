public static void main( String[] args )
{
   LinkedListTest llt = new LinkedListTest();

   llt.insert(1000);
   llt.insert(2000);
   llt.insert(2000);
   llt.insert(3000);

   llt.printList();
   System.out.println();

   llt.delete(2000);
   llt.printList();
}