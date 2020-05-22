import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

public class SO45704851
{

  public static void main(String... argv)
    throws Exception
  {
    String example = "\u00c3\u0092\u00c3\u00bd\u00c2\u00aa\u00c2\u009e\u001c\u00c2\u0089\u001cG";
    long tod = sbrogliare(example);
    System.out.printf("ToD: 0x%016x%n", tod);
    Instant time = toInstant(tod);
    System.out.printf("Instant: %s%n", time);
  }

  /**
   * Clean up an infernal mess, miraculously bestowing a 64-bit time-of-day.
   */
  public static long sbrogliare(String garbage)
  {
    byte[] utf8 = new byte[garbage.length()];
    for (int idx = 0; idx < garbage.length(); ++idx)
      utf8[idx] = (byte) garbage.charAt(idx);
    String raw = new String(utf8, StandardCharsets.UTF_8);
    if (raw.length() != 8)
      throw new IllegalArgumentException();
    long n = 0;
    for (int idx = 0; idx < raw.length(); ++idx) {
      char ch = raw.charAt(idx);
      if (ch > 255)
        throw new IllegalArgumentException();
      n = n << 8 | ch;
    }
    return n;
  }

  private static final OffsetDateTime zero = OffsetDateTime.parse("1900-01-01T00:00Z");

  /**
   * Convert 64-bit time-of-day to {@code Instant}.
   */
  public static Instant toInstant(long tod)
  {
    long nanos = (125 * (tod >>> 32) << 23) + (125 * (tod & 0xFFFFFFFFL) >>> 9);
    return zero.plus(nanos, ChronoUnit.NANOS).toInstant();
  }

}