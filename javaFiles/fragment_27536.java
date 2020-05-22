public void printHand() {
      ListIterator<Card> it = hand.listIterator();
      if(it.hasNext())
         System.out.print(it.next());
      while(it.hasNext())
         System.out.print(", " + it.next());
      System.out.println();
   }