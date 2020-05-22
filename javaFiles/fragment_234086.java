// MediaList.java
import java.util.ArrayList;

public class MediaList
{
  private ArrayList<Media> mediaList;

  public MediaList()
  {
    mediaList = new ArrayList<>();
  }

  public void add(Media media)
  {
    set(media, +1);
  }

  public void remove(Media media)
  {
    set(media, -1);
  }

  private void set(Media media, int change)
  {
    if (change == 0)
    {
      return;
    }

    int indexOfMedia = mediaList.indexOf(media);

    if (indexOfMedia != -1)
    {
      Media m = mediaList.get(indexOfMedia);
      m.setNumberOfCopies(m.getNumberOfCopies() + change);

      if (change < 0 && m.getNumberOfCopies() <= 0)
      {
        mediaList.remove(media);
      }
    }
    else if (change > 0)
    {
      mediaList.add(media);
    }
  }

  // And so on...
}