public class Test {
  public void test() {
    int[] limits = {3, -5, 7};
    int[] order = {0, 2, 1};
    int[] starts = {0, 0, 0};
    int[] steps = {1, -1, 2};
    NDimensionalStepper nds = new NDimensionalStepper(limits, order, starts, steps);
    do {
      System.out.println(nds);
    } while (nds.step());
  }

  public static void main(String args[]) {
    new Test().test();
  }

  public static class NDimensionalStepper {
    // The current positions in each dimension.
    // Note that i[order[0]] is the fastest mover.
    final int[] i;
    // Starts.
    final int[] starts;
    // Steps.
    final int[] steps;
    // Limits.
    final int[] limits;
    // Order.
    final int[] order;
    // The (unordered) dimension we last stepped.
    int d = 0;

    // Full constructor.
    public NDimensionalStepper(int[] limits, int[] order, int[] starts, int[] steps) {
      // Should parameter check to ensure all are the same length.
      // Should also check that each dimension will terminate.
      this.i = Arrays.copyOf(starts, starts.length);
      this.starts = Arrays.copyOf(starts, starts.length);
      this.steps = Arrays.copyOf(steps, steps.length);
      this.limits = Arrays.copyOf(limits, limits.length);
      this.order = Arrays.copyOf(order, order.length);
    }

    // Default steps to 1.
    public NDimensionalStepper(int[] limits, int[] order, int[] starts) {
      this(limits, order, starts, defaultSteps(limits, starts));
    }

    // Default steps - 1 Towards limits.
    private static int[] defaultSteps(int[] limits, int[] starts) {
      int[] steps = new int[limits.length];
      for (int i = 0; i < limits.length; i++) {
        // Step towrds limits.
        steps[i] = (int) Math.signum(limits[i] - starts[i]);
      }
      return steps;
    }

    // Default starts to 0.
    public NDimensionalStepper(int[] limits, int[] order) {
      this(limits, order, defaultStarts(limits.length));
    }

    // Default starts - 0, 0, ...
    private static int[] defaultStarts(int d) {
      int[] starts = new int[d];
      Arrays.fill(starts, 0);
      return starts;
    }

    // Default order to normal.
    public NDimensionalStepper(int[] limits) {
      this(limits, defaultOrder(limits.length));
    }

    // Default order - ..., 1, 0
    private static int[] defaultOrder(int d) {
      int[] order = new int[d];
      for (int i = 0; i < d; i++) {
        order[i] = d - i - 1;
      }
      return order;
    }

    // Get the current position in dimension d.
    public int get(int d) {
      return i[d];
    }

    // Take just one step. Return false if cant.
    public boolean step() {
      boolean stepped = false;
      boolean finished = false;
      while (!stepped && !finished) {
        // Which dimension should be stepped (depends on order).
        int o = order[d];
        // Can we step in the current dimension?
        while (finished(o) && d < order.length - 1) {
          // Reached a limit! - Move up one dimension.
          o = order[++d];
        }
        if (d < order.length && !finished(o)) {
          // Step it.
          i[o] += steps[o];
          stepped = true;
          // Zero all lower dimensions.
          while (d > 0) {
            d -= 1;
            i[order[d]] = starts[order[d]];
          }
        } else {
          // Got to the last without finding one below limit. Finished!
          finished = true;
        }
      }
      return !finished;
    }

    // Equal or passed the limits.
    private boolean finished(int o) {
      int sign = (int) Math.signum(steps[o]);
      return sign * (i[o] + steps[o]) >= sign * limits[o];
    }

    @Override
    public String toString() {
      StringBuilder s = new StringBuilder();
      s.append("{");
      for (int d = 0; d < order.length; d++) {
        s.append(get(d));
        if (d < order.length - 1) {
          s.append(",");
        }
      }
      s.append("}");
      return s.toString();
    }
  }
}