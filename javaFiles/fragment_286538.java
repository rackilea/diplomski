public class Test {
  public static void main(String args[]){
    int[] i = fromString(Arrays.toString(new int[] { 1, 2, 3} ));
  }

  private static int[] fromString(String string) {
    String[] strings = string.replace("[", "").replace("]", "").split(", ");
    int result[] = new int[strings.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = Integer.parseInt(strings[i]);
    }
    return result;
  }
}