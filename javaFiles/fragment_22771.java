public class Pie {
  private int a = 1;
  protected Slice[] slices;

  // Pie constructor
  public Pie(int n) {
    sliceGenerator(n);
  }

  private void sliceGenerator(int n) {
    newSliceArray(n);
    final float sweepAngle = 360.0f / n;
    float startAngle = 0;
    for (int i = 0; i < n; i++) {
      slices[i] = newSlice(startAngle);
      startAngle += sweepAngle;
    }
  }

  protected void newSliceArray(int n) {
    slices = new Slice[n];
  }


  protected Slice newSlice(float startAngle) {
    return new Slice(startAngle);
  }

  @Override
  public String toString() {
    String t = "";
    for (Slice s : slices) {
      t += s.toString();
    }
    return t;
  }

  // Inner class...
  public class Slice {
    public Slice(float startAngle) {
      // set some private fields based on startAngle and generic pie
    }

    @Override
    public String toString() {
      return "" + a;
    }
  }
}