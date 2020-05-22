public enum Pick
{
  PickThree(30),
  PickFour(40),
  PickFive(50);

  private int limit;

  private Pick(int i) { limit = i; }

  public int getLimit() { return limit; }
}