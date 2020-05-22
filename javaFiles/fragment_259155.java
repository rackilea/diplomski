public class PairOfDice {
  private Die dieOne = new Die();
  private Die dieTwo = new Die();

  public static void main(String[] args) {
    PairOfDice pair = new PairOfDice();
    System.out.printf("Pair: %d - %d%n", pair.getDieOneValue(), pair.getDieTwoValue());
  }

  public int getDieOneValue() {
     dieOne.roll();
    return dieOne.getValue();
  }

  public int getDieTwoValue() {
    dieTwo.roll();
    return dieTwo.getValue();
  }
}