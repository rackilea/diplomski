public void shift(int times) {                          
    Random randomGenerator=new Random();

    for (int counter=0;counter < times; counter++){

       int card1=randomGenerator.nextInt(52);
       int card2=randomGenerator.nextInt(52);

       Card temp=new Card(null,null);
       temp=cards[card1];
       cards[card1]=cards[card2];
       cards[card2]=temp;
    }
}