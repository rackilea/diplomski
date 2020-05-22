public class RewardValue {
  private int value;

  public RewardValue(int startValue) {
    this.value = startValue;
  }

  public void increment() {
    value++;
  }

  public int getValue() {
    return value;
  }
}