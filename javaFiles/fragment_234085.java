// Media.java
public class Media
{
  private final String support;
  private final String title;
  private int numberOfCopies;

  public Media(Media media)
  {
    this(media.title, media.support, media.numberOfCopies);
  }

  public Media(String title, String support, int numberOfCopies)
  {
    this.title = title;
    this.support = support;
    this.numberOfCopies = numberOfCopies;
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

  public int getNumberOfCopies()
  {
    return numberOfCopies;
  }

  public void setNumberOfCopies(int numberOfCopies)
  {
    this.numberOfCopies = numberOfCopies;
  }
}