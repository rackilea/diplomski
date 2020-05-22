public abstract class Värdesaker {
  protected String namn;
  protected double värde;
  protected double moms = 1.25;

  public static void main(String[] args)
  {

    Värdesaker v = new smycken("Test", false, 0);

  }

  static class smycken extends Värdesaker
  {

    double vikt, ädelstenar;

    public smycken(String namn, boolean guld, int ädelstenar)
    {
      this.namn = namn;
      this.ädelstenar = ädelstenar;
      if (guld) {
        this.värde = (2000 + (ädelstenar * 500)) * moms;
      } else {
        this.värde = (500 + (ädelstenar * 500)) * moms;
      }

    }
  }
}