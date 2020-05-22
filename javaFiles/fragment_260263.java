public class TDLL extends Library {
  TDLL INSTANCE = (TDLL) Native.loadLibrary("myjnalib.dll", TDLL.class);
  public static TDLL getInstance() {
    return INSTANCE;
  }
  WString teste3();
}

System.out.println(TDLL.getInstance().teste3().toString());