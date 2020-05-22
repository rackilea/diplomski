public class CustomLabelsVideo extends Video {

   @Facebook("custom_labels")
   private List<String> customLabels = new ArrayList<>();

   public List<String> getCustomLabels() {
      return customLabels;
   }

   public void setCustomLabels(List<String> customLabels) {
      this.customLabels = customLabels;
   }
}