public enum Functions {
  SIGMOID {
    public double function(double value) { return 1 / (1 + Math.exp(0 - value)); }
    public double derivative(double value) { return ...; }
  },
  OTHER_FUNCTIONS { ... }

  public abstract double function(double value);
  public abstract double derivative(double value);
}