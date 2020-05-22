public class Section {

   @SerializedName("title")
   @Expose
   private String title;
   @SerializedName("level")
   @Expose
   private int level;
   @SerializedName("content")
   @Expose
   private List<Content> content = new ArrayList<Content>();
   @SerializedName("images")
   @Expose
   private List<Image> images = new ArrayList<Image>();

   /**
   * 
   * @return
   * The title
   */
   public String getTitle() {
      return title;
   }

   /**
   * 
   * @param title
   * The title
   */
   public void setTitle(String title) {
      this.title = title;
   }

   /**
   * 
   * @return
   * The level
   */
   public int getLevel() {
      return level;
   }

   /**
   * 
   * @param level
   * The level
   */
   public void setLevel(int level) {
      this.level = level;
   }

   /**
   * 
   * @return
   * The content
   */
   public List<Content> getContent() {
      return content;
   }

   /**
   * 
   * @param content
   * The content
   */
   public void setContent(List<Content> content) {
      this.content = content;
   }

   /**
   * 
   * @return
   * The images
   */
   public List<Image> getImages() {
      return images;
   }

   /**
   * 
   * @param images
   * The images
   */
   public void setImages(List<Image> images) {
      this.images = images;
   }

}