import java.util.Arrays;

public class Test {
  public static final void main(String[] args) throws InterruptedException {
    String[] raw = "01234".split("");
    String[] strArray = Arrays.copyOfRange(raw, 1, raw.length);
    System.out.println(Arrays.toString(strArray));
  }
}