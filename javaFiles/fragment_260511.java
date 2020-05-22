//create a Random object, and an integer 
//indicating the current card as a member of your class:
Random random = new Random();
int actual = 0;

//then for random card selection:
actual = random.nextInt(52);
display.setImageResource(cards[actual]);

//for getting a higher card:
actual = actual<51 ? actual+1 : actual;
display.setImageResource(cards[actual]);

//for getting a lower card:
actual = actual>0 ? actual-1 : actual;
display.setImageResource(cards[actual]);