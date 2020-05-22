public class ColorField {
   private String[] colorString = new String[36];
   private int length = 9;
   public ColorField() {
     // init colorString
   }

   public void switchTo9() {
     this.length = 9;
   }

   public void switchTo36() {
     this.length = 36;
   }

   public int getLength() {
     return this.length;
   }

   public String getField(int idx) {
     // sanity checks omitted
     return colorString[idx];
   }

   // more stuff
}