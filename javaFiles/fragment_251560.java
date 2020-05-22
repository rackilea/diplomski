public class ListRander {

   private String _title;
   private Bitmap _thumb;

   public ListRander(String title, Bitmap thumb) {
      _title = title;
      _thumb = thumb;
   }

   public String getTitle() {
      return _title;
   }
   public Bitmap getThumb() {
      return _thumb;
   }
}