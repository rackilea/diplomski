public class Model {
   public static Model sharedModel = new Model();

   public static class Receipts {
       private Bitmap image;
       private String currentDate = "";
   }

   public Receipts[] allreceipts;
}