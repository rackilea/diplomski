class CellStyleMap
{
  public static synchronized void addStyle(String    identifier,
                                           CellStyle style)
  {
    styles.put(identifier, style);
  }

  public static synchronized CellStyle getStyle(String identifier)
  {
    return (styles.get(identifier));
  }

  private static Hashtable<String, CellStyle> styles = new Hashtable<String, CellStyle>();

} // class CellStyleMap