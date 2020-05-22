public final class JavaTrueRing implements ScalaObject {
  public static final  MODULE$;

  static {
    new JavaTrueRing();
  }

  public void rule() {
    Predef.MODULE$.println("To rule them all");
  }

  private JavaTrueRing() {
    MODULE$ = this;
  }

  // Forwarders
  public static final void rule() {
    MODULE$.rule();
  }  
}