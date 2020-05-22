public class ExpectedVsActual {
  // if you don't care too much of your data integrity
  // along other lines of coding, make those public
  // and forget about getters
  protected int expected;
  protected int actual;

  public ExpectedVsActual(int exp, int act) {
    this.expected=exp;
    this.actual=act;
  }
  public int getExpected() {
    return this.expected;
  }
  public int getActual() {
     return this.actual;
  }
}