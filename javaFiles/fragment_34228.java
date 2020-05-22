public class Entry {
  private String name;
  private TagList tagList;
}


public class TagList {

   private final List<Tag> tags;

   public TagList(List<Tag> tags) {
      this.tags = tags;
   }

   public List<Tag> getTags() {
      return tags;
   }
}