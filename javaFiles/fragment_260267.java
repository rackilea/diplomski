public class TDLL {
  static {
    System.loadLibrary("myjnalib");
  }

  public native string test3();
}

System.out.println(new TDLL().teste3());