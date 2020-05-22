import util.USBUIRT;
public class Uirt {
    static {
        System.loadLibrary("uuirtdrv");
    }

public static void main(String[] args) {
    String code = "0000";   
    try {
        USBUIRT.transmitIR(code, 2, 3, 2);
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}