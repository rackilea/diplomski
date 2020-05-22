public class run {
  public static void main(String[] argv) {
    System.loadLibrary("test");
    DataStruct[] result = test.get_all_data(0);
    for (int i = 0; i < result.length; ++i) {
      System.out.println(result[i].getId());
    }
  }
}