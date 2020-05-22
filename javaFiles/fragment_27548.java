// get an array of all the cards
private Card[]cards=Cards.values();
// this generates random numbers
private Random random = new Random();
// choose a card at random
final Card random(){
     return cards[random.nextInt(cards.length)];
}