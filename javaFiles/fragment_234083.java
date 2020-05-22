// Media.java
public class Media
{
  private final String support;
  private final String title;

  public Media(String title, String support)
  {
    this.title = title;
    this.support = support;
  }

  public Media(Media media)
  {
    this(media.title, media.support);
  }

  @Override
  public int hashCode()
  {
    return 31 * title.hashCode() + support.hashCode();
  }

  @Override
  public boolean equals(Object object)
  {
    if (object instanceof Media)
    {
      Media media = (Media) object;

      return media.title.equals(title) &&
             media.support.equals(support);
    }

    return false;
  }
}