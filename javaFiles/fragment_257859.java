public class Soave extends EOS {
public double aF;
double uValue = 1;
double wValue = 0;
public double fW;

public Soave (double aFactor, double criticalTemperature, double criticalPressure, double temperature, double pressure, double molecularWeight) {
    super(criticalTemperature, criticalPressure, temperature, pressure, molecularWeight);
    this.aF = aFactor;
    fW = 0.48+1.574*aF-0.176*Math.pow(aF, 2); //This will give you the proper number.
}