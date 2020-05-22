public class Ball {

   private float length;
   private float weight;
   public Ball()
   {
     this.length = 100;
     this.weight = 250;
   }
   public Ball(float length, float peso)
   {
      this.length = length;
      this.weight = weight;
   }
   public float getLength()
   {
      return length;
   }
   public float getWeight()
   {
     return weight;
   }
   public void kickBall()
   {
     System.out.println("you kicked the ball");
   }
   public void atraparPelota()
   {
     System.out.println("you caught the ball");
   }