public class Health {

   private int value;

   public Health(int value) {
      if (value < 0 || value > 100) {
         throw new IllegalArgumentException();
      } else {
         this.value = value;
      }
   }

   public int getHealthValue() {
      return value;
   }


   public void setHealthValue(int newValue) {
    if (newValue < 0 || newValue > 100) {
         throw new IllegalArgumentException();
      } else {
      value = newValue;
    }
   }

}