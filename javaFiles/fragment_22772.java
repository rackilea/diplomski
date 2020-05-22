public class ApplePie extends Pie {
  private int b = 2;

  // protected Slice[] slices;

  // Apple Pie constructor
  public ApplePie(int n) {
    super(n);
  }

  protected void newSliceArray(int n) {
    slices = new Slice[n];
  }

  protected Slice newSlice(float startAngle) {
    return new Slice(startAngle);
  }

  // Inner class...
  public class Slice extends Pie.Slice {
    public Slice(float startAngle) {
      super(startAngle);
      // set some **additional** private fields based on startAngle **specific to apple pie**
      // appleness or something
    }

    @Override
    public String toString() {
      return b + "";
    }
  }
}