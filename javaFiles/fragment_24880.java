public class MyEntry implements Serializable {

   private float x;
   private float y;

   public MyEntry(float x, float y) {
       this.x = x;
       this.y = y;
   }

   public MyEntry(){

   }

   public float getX() {
       return x;
   }

   public float getY() {
       return y;
   }

   public void setX(float x) {
       this.x = x;
   }

   public void setY(float y) {
       this.y = y;
   }
}