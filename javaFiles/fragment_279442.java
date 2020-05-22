@Root
  public class Example {
     @ElementListUnion({
        @ElementList(entry="images", type=Image.class, inline=true),
        @ElementList(entry="videos", type=Vidio.class, inline=true),
     })
     private List<Data> data;
  }
 //vidio
 @Default
  public class Vidio {
    private String link;
    private String mask;
  }
  //image
  @Default
  public class Image {
    private String url;
    private String mask;

  }