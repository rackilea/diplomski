import org.apache.commons.lang.RandomStringUtils;
public class RandomStringUtilsTrial {
  public static void main(String[] args) {
    System.out.print("8 char string  >>>");
    System.out.println(RandomStringUtils.random(8, true, true));

  }
}