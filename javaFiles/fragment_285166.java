import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Notation: n.n.n.n, where n can be:
 * - an integer such that 0 &lt;= n &lt;= 255;
 * - an interval m-n, where 0 &lt;= m &lt;= n &lt;= 255
 * - an asterisk (*), synonym for interval 0-255.
 * The address parts are stored as returned as 16-bits integers (short) in order to
 * avoid confusion that might come from the fact that integers between 128 and 255
 * are considered negative (-128 to -1) when handled as byte values.
 * Instances of this class are immutable.
 */
public class InetAddressRange {

  private static final Pattern P_DIGITS = Pattern.compile("\\d+");
  private static final Pattern P1 = Pattern.compile("([0-9\\*\\-\\[\\],]+)\\.([0-9\\*\\-\\[\\],]+)\\.([0-9\\*\\-\\[\\],]+)\\.([0-9\\*\\-\\[\\],]+)");
  private static final Pattern P2 = Pattern.compile("(\\d+)\\-(\\d+)");

  private final short[] min = new short[4];
  private final short[] max = new short[4];

  public InetAddressRange(String expr) {
    parse(expr);
  }

  private void parse(String expr) {
    Matcher m1 = P1.matcher(expr);
    if (!m1.matches()) {
      throw error(expr);
    }

    for (int i = 0; i < 4; i++) {
      String token = m1.group(i + 1);
      if (P_DIGITS.matcher(token).matches()) {
        // Integer between 0 and 255 (else only the last 8 bits are kept)
        min[i] = max[i] = (short) (Integer.parseInt(token) & 0xff);
      } else if (token.equals("*")) {
        // Asterisk = interval 0-255
        min[i] = 0;
        max[i] = 0xff;
      } else {
        // Interval a-b
        Matcher m2 = P2.matcher(token);
        if (m2.matches()) {
          min[i] = (short) (Integer.parseInt(m2.group(1)) & 0xff);
          max[i] = (short) (Integer.parseInt(m2.group(2)) & 0xff);
        } else {
          throw error(expr);
        }
      }
    }
  }

  private static IllegalArgumentException error(String expr) {
    return new IllegalArgumentException("The expression " + expr + " isn't a valid IP address interval.");
  }

  public short getMin(int i) {
    return min[i];
  }

  public short getMax(int i) {
    return max[i];
  }

  public boolean isInRange(InetAddress adr) {
    byte[] parts = adr.getAddress();
    for (int i = 0; i < 4; i++) {
      if (min[i] > (parts[i] & 0xff) || max[i] < (parts[i] & 0xff)) {
        return false;
      }
    }
    return true;
  }

  public boolean isInRange(String adr) {
    String[] tokens = adr.split("\\.");
    if (tokens.length < 4) {
      return false;
    }
    for (int i = 0; i < 4; i++) {
      int part = Integer.parseInt(tokens[i]);
      if (min[i] > part || max[i] < part) {
        return false;
      }
    }
    return true;
  }

  public List<String> getAddresses() {
    List<String> addrs = new ArrayList<>();
    for (short a = min[0]; a <= max[0]; a++) {
      for (short b = min[1]; b <= max[1]; b++) {
        for (short c = min[2]; c <= max[2]; c++) {
          for (short d = min[3]; d <= max[3]; d++) {
            String addr = String.format("%d.%d.%d.%d", a, b, c, d);
            addrs.add(addr);
          }
        }
      }
    }
    return addrs;
  }

  public static void main(String[] args) {
    InetAddressRange range = new InetAddressRange("9.1.0.0-10");
    range.getAddresses().forEach(System.out::println);
  }

}