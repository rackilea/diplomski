public class XSSUtils {

private XSSUtils()
{

}

public static String stripXSS(String value) {
    return value == null ? value : escapeHtml4(value);
  }
}