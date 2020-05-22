public class Image {

   @SerializedName("src")
   @Expose
   private String src;
   @SerializedName("caption")
   @Expose
   private String caption;

   /**
   * 
   * @return
   * The src
   */
   public String getSrc() {
      return src;
   }

   /**
   * 
   * @param src
   * The src
   */
   public void setSrc(String src) {
      this.src = src;
   }

   /**
   * 
   * @return
   * The caption
   */
   public String getCaption() {
      return caption;
   }

   /**
   * 
   * @param caption
   * The caption
   */
   public void setCaption(String caption) {
      this.caption = caption;
   }

}