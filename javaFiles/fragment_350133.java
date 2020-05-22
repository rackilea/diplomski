public class Printable {
  public void println(Var var);
}

public class Fac {
  public static Printable of(Object o) {
    return new Printable(o);
  }

  public static Var var(Class<?> clazz) {
    return new Var(clazz);
  }

}