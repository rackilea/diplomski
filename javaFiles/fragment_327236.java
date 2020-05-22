public class StrVal implements Comparable<StrVal> {

  private double val;
  private String str;

  public StrVal(double val, String str) {
    this.val = val;
    this.str = str;
  }

  @Override
  public int compareTo(StrVal o) {
    return (int)(this.val - o.val);
  }

  public double getVal() {
    return val;
  }

  public String getStr() {
    return str;
  }
}