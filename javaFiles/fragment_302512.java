public class Content {

   @SerializedName("type")
   @Expose
   private String type;
   @SerializedName("text")
   @Expose
   private String text;

   /**
   * 
   * @return
   * The type
   */
   public String getType() {
      return type;
   }

   /**
   * 
   * @param type
   * The type
   */
   public void setType(String type) {
      this.type = type;
   }

   /**
   * 
   * @return
   * The text
   */
   public String getText() {
      return text;
   }

   /**
   * 
   * @param text
   * The text
   */
   public void setText(String text) {
      this.text = text;
   }

 }