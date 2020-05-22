import java.util.Arrays;
import java.util.Comparator;

public class VersionNumberComparator implements Comparator<String> {
  @Override
  public int compare(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    int major1 = major(v1);
    int major2 = major(v2);
    if (major1 == major2) {
      return minor(v1).compareTo(minor(v2));
    }
    return major1 > major2 ? 1 : -1;
  }

  private int major(String[] version) {
    return Integer.parseInt(version[0]);
  }

  private Integer minor(String[] version) {
    return version.length > 1 ? Integer.parseInt(version[1]) : 0;
  }

  public static void main(String[] args) {
    String[] k1 = { "0.10", "0.2", "0.1", "0", "1.10", "1.2", "1.1", "1",
        "2.10", "2", "2.2", "2.1" };
    Arrays.sort(k1, new VersionNumberComparator());
    System.out.println(Arrays.asList(k1));
  }
}