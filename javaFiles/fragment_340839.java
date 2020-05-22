public class TVset {
  public double[] voltageA = { 0.0 };
  public double[] voltageB = { 0.0 };
  public double[] voltageC = { 0.0 };
}

class Voltmeter{
  final double[] theField;

  Voltmeter(double[] theField) {
    this.theField = theField;
  }

  double getVoltage() {
    return theField[0];
  }
}
// works just fine.
Voltmeter meter = new Voltmeter(tv1.voltageB);