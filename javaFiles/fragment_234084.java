// MediaMap.java
import java.util.HashMap;
import java.util.Map;

public class MediaMap
{
  // Media to its Number of Copies mapping.
  private Map<Media, Integer> mediaMap;

  public MediaMap()
  {
    mediaMap = new HashMap<>();
  }

  public void add(Media media)
  {
    mediaMap.put(media, mediaMap.getOrDefault(media, 0) + 1);
  }

  public void removeOneMedia(Media media)
  {
    if (mediaMap.containsKey(media))
    {
      mediaMap.put(media, mediaMap.get(media) - 1);
    }
  }

  // And so on...
}