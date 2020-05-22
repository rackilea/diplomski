public class MyNamespacePrefixMapper extends NamespacePrefixMapper {

  public String getPreferredPrefix(String namespaceUri,
                               String suggestion,
                               boolean requirePrefix) {
    if (requirePrefix) {
      if ("http://www.example.org/abc".equals(namespaceUri)) {
        return "abc";
      }
      if ("http://www.w3.org/1999/xlink".equals(namespaceUri)) {
        return "xlink";
      }
      return suggestion;
    } else {
      return "";
    }
  }
}