public class PairOfDice {
  private int dieOneValue;
  private int dieTwoValue;

  public PairOfDice {
    Die die = new Die();

    // get a value for the first die
    die.roll();
    dieOneValue = die.getValue();

    // get a value for the 2nd die
    die.roll();
    dieTwoValue = die.getValue();
  }

  public int getDieOneValue() {
    return dieOneValue;
  }

  ...