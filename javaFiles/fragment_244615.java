import java.util.Arrays;
public class App {
  public static void main(String[] args) {
    char[] line = new char[100];
    for (int i = 0; i < 4; i++) {
      Arrays.fill(line, ' ');
      line[i] = '*';
      System.out.println(line);
    }
  }
}