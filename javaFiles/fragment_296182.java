public class MyNsPrefixMapper extends NamespacePrefixMapper
{
  public String getPreferredPrefix(String uri, String suggest, boolean require)
  {
    if("http://www.theronyx.com/mdasj/xmldata".equals(uri) ){return "";}
    return suggest;
  }

  public String[] getPreDeclaredNamespaceUris()
  {
    // String[] result = new String[1];
    // result[0] = "http://www.theronyx.com/mdasj/xmldata";
    return new String[0];
  }
}