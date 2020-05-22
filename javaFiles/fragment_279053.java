public class Test {
  public static void main(String[] args) {
    convert("13.0");
    convert("-7.0");
  }

  private static void convert(String satpos) {
    String satposs = satpos.replaceAll("\\.", "");
    int satposition = Integer.parseInt(satposs);
    if (satposition < 0) {
      satposition += 3600;
    }
    String nids = Integer.toHexString(satposition);
    String finished = nids + "0000";
    System.out.println(finished);
  }

}