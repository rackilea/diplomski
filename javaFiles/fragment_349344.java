public final class Temperature {
  public enum Scale {
    Celsius, Fahrenheit, Kelvin
  }

  private final double temperature;

  private Temperature(double temperature) {
    this.temperature = temperature;
  }

  public static Temperature create(double temperature, Scale scale) {
    switch (scale) {
      case Celsius:
        return new Temperature(temperature + 273.15);
      case Fahrenheit:
        return new Temperature((temperature + 459.67) * 5.0 / 9.0);
      case Kelvin:
        return new Temperature(temperature);
      default:
        throw new IllegalArgumentException("Unknown scale");
    }
  }

  public double convertTo(Scale scale) {
    switch (scale) {
      case Celsius:
        return temperature - 273.15;
      case Fahrenheit:
        return temperature * 9.0 / 5.0 - 459.67;
      case Kelvin:
        return temperature;
      default:
        throw new IllegalArgumentException("Unknown scale");
    }
  }
}