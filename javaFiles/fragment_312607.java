DeckOfCards deck = new DeckOfCards(); 
PlayingCard card = deck.deal(); 
PlayingCard next = deck.deal(); 
System.out.println("Welcome to the High Low Card Game.\nYou're current card is: "+card.toPictograph()+". Will the Next card be higher/lower/equal to the current card?\nType Quit to exit.");
Scanner inputScanner = new Scanner(System.in);
String s = inputScanner.next();
if(s.equalsIgnoreCase("higher"))
{
    System.out.println("Congradulations you won");
    wins++;
}
else if (s.equalsIgnoreCase("lower"))
{
    System.out.println("You suck");
}
else if (s.equalsIgnoreCase("equal"))
{
    System.out.println("You suck");
}