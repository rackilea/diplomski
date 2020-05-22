import javafx.geometry.Side;


public class AutoRangeTester {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    AutoRangeTester art = new AutoRangeTester();
    art.autoRange(Double.MIN_VALUE, Double.MIN_VALUE + 0.000000000000000000000000000000001, 100, 50);
  }

  /**
   * Called to set the upper and lower bound and anything else that needs to be
   * auto-ranged
   *
   * @param minValue  The min data value that needs to be plotted on this axis
   * @param maxValue  The max data value that needs to be plotted on this axis
   * @param length    The length of the axis in display coordinates
   * @param labelSize The approximate average size a label takes along the axis
   *
   * @return The calculated range
   */
  public Object autoRange(double minValue, double maxValue, double length,
                          double labelSize) {
    final Side side = Side.LEFT;
    // check if we need to force zero into range
    if (true) {
      if (maxValue < 0) {
        maxValue = 0;
      } else if (minValue > 0) {
        minValue = 0;
      }
    }
    final double range = maxValue - minValue;
    // pad min and max by 2%, checking if the range is zero
    final double paddedRange = (range == 0) ? 2 : Math.abs(range) * 1.02;
    final double padding = (paddedRange - range) / 2;
    // if min and max are not zero then add padding to them
    double paddedMin = minValue - padding;
    double paddedMax = maxValue + padding;
    // check padding has not pushed min or max over zero line
    if ((paddedMin < 0 && minValue >= 0) || (paddedMin > 0 && minValue <= 0)) {
      // padding pushed min above or below zero so clamp to 0
      paddedMin = 0;
    }
    if ((paddedMax < 0 && maxValue >= 0) || (paddedMax > 0 && maxValue <= 0)) {
      // padding pushed min above or below zero so clamp to 0
      paddedMax = 0;
    }
    // calculate the number of tick-marks we can fit in the given length
    int numOfTickMarks = (int) Math.floor(length / labelSize);
    // can never have less than 2 tick marks one for each end
    numOfTickMarks = Math.max(numOfTickMarks, 2);
    // calculate tick unit for the number of ticks can have in the given data range
    double tickUnit = paddedRange / (double) numOfTickMarks;
    // search for the best tick unit that fits
    double tickUnitRounded = 0;
    double minRounded = 0;
    double maxRounded = 0;
    int count = 0;
    double reqLength = Double.MAX_VALUE;

    // loop till we find a set of ticks that fit length and result in a total of less than 20 tick marks
    while (reqLength > length || count > 20) {
      int exp = (int) Math.floor(Math.log10(tickUnit));
      final double mant = tickUnit / Math.pow(10, exp);
      double ratio = mant;
      if (mant > 5d) {
        exp++;
        ratio = 1;
      } else if (mant > 1d) {
        ratio = mant > 2.5 ? 5 : 2.5;
      }

      tickUnitRounded = ratio * Math.pow(10, exp);

      minRounded = Math.floor(paddedMin / tickUnitRounded) * tickUnitRounded;
      maxRounded = Math.ceil(paddedMax / tickUnitRounded) * tickUnitRounded;

      count = 0;
      for (double major = minRounded; major <= maxRounded; major
              += tickUnitRounded, count++) {
        System.out.println("minRounded: " + minRounded);
        System.out.println("maxRounded: " + maxRounded);
        System.out.println("major: " + major);
        System.out.println("tickUnitRounded: " + tickUnitRounded);
        System.out.println("-------------------------------------");
      }

    }
    return null;
  }

}