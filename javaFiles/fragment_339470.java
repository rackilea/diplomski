class Player {
  private static final Random generator = new Random();

  private static final int WIN_SCORE = 75;

  private final String name;
  private int totalSum;
  private final int winScore;

  public Player( String name, int winScore ) {
    super();
    this.name = name;
    this.winScore = winScore;
  }

  public boolean executeTurn() {

    boolean rollAgain = roll();

    while( rollAgain ) {
      System.out.println( name + " gets to roll again" );
      rollAgain = roll();
    }

    //returns true if the player won
    return totalSum >= winScore;
  }

  private boolean roll() {
    int dice1 = generator.nextInt( 6 ) + 1;
    int dice2 = generator.nextInt( 6 ) + 1;
    totalSum += dice1 + dice2;

    System.out.println( name + " rolls a " + dice1 + " and a " + dice2 );
    System.out.println( name + " now has " + totalSum );

    //return true if he may roll again
    return dice1 == dice2;
  }

  public String getName() {
    return name;
  }
}