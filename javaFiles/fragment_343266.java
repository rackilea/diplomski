public class HelloWorld {
    public static void main(String[] args) {
      // result: 214930807
      System.out.println("result: " + keygen("7043-1667-03f9-f6", "C6AD-0E40") );
    }
    private static int keygen(String code, String serial) {
      return (int)((Long.parseLong(code.substring(0,12).replaceAll("[a-zA-Z-]",""))+0x26946948)^Long.parseLong(serial.replaceAll("[-]", ""),16));
    }
}