public abstract class Voltmeter{ // or use an interface
  public abstract double get();
  public abstract void set(double voltage);
}

public class TVset {
  private double _voltageA = 0.0;
  private double _voltageB = 0.0;
  private double _voltageC = 0.0;
  public final Voltmeter voltageA = new Voltmeter() {
     public double get() { return _voltageA; }
     public void set(double voltage) { _voltageA = voltage; }
  }
  public final Voltmeter voltageB = new Voltmeter() {
     public double get() { return _voltageB; }
     public void set(double voltage) { _voltageB = voltage; }
  }
  public final Voltmeter voltageC = new Voltmeter() {
     public double get() { return _voltageC; }
     public void set(double voltage) { _voltageC = voltage; }
  }
}