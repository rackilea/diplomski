public enum ArticlePermission
{
  CanRead(1),
  CanWrite(2),
  CanDelete(4),
  CanMove(16); // what happened to 8?

  private int _val;
  ArticlePermission(int val)
  {
    _val = val;
  }

  public int getValue()
  {
    return _val;
  }

  public static List<ArticlePermission> parseArticlePermissions(int val)
  {
    List<ArticlePermission> apList = new ArrayList<ArticlePermission>();
    for (ArticlePermission ap : values())
    {
      if (val & ap.getValue() != 0)
        apList.add(ap);
    }
    return apList;
  }
}