public class TDLL extends Library {
  TDLL INSTANCE = (TDLL) Native.loadLibrary("myjnalib.dll", TDLL.class);
  public static TDLL getInstance() {
    return INSTANCE;
  }
  int teste3(Memory buf, int bufsize);
}

Memory buf = new Memory(10);
TDLL.getInstance().teste3(buf, buf.size());
System.out.println(buf.getString(0, true));