public class Temperature {
   private float temp;
   char scale;

   //first constructor
   /*
   *Notice how in this first constructor, I put scale
   *as 'C' since there was no char value being passed
   *as a parameter (no char scale inside the brackets)
   *Now i did get a float temp passed a a parameter so 
   *I set whatever that temp is to the temp of this class
   *also known as this.temp (this refers to THIS class
   */
   public Temperature(float temp) {
      this.temp = temp;
      scale = 'C';
      //other way
      //this(temp, 'C');  
   }

   //second constructor
   /*
   *Now this constructor is the exact same case at the 
   *first one, except this one has the char scale passed.
   *Since no temp is passed, I set it to 0 as no value is specified 
   */
   public Temperature(char scale) {
      this.scale = scale;
      temp = 0;
      //other way
      //this(0, scale); 
   }

   //third constructor
   /*
   *This third one is having both temp and scale being specified
   *which means you don't need to put any initial value (0 and Celcius)
   *Just set these objects to whatever is being passed by through the 
   *parameters
   */
   public Temperature(float temp, char scale) {
      this.temp = temp;
      this.scale = scale;
   }

   //fourth constructor
   /*
   *This last one has no parameters through so
   *you can just set both the scale and temp to 
   *0 and 'C' respectively.
   */
   public Temperature() {
      temp = 0;
      scale = 'C';
      //other way
      //this(0, 'C'); 
   }
}