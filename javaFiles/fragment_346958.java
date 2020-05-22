System.out.println("Deal to 4 Hands: "); 

 Hand[] hands=new Hand[4];
 for(int i=0;i<hands.length;i++)
      hands[i]=new Hand();
 for(Hand hand:hands)
      hand.addSingleCard(Deck.deal());
 for(Hand hand:hands)
      hand.addSingleCard(Deck.deal());
 System.out.println("Cards left in deck: " + Deck.size());
 for(int i=0;i<hands.length;i++)
      System.out.println("Player "+i+"'s Hand: \n" + hands[i].getHand());