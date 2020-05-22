public class Fraction{
       private int numerator;
       private int denominator;

       public void setDenominator(int d) throws IllegalArgumentException{
             if(d == 0){
                 throw new IllegalArgumentExcepton("Denominator cannot be 0");
             }
             this.denominator = d;
       }
      ...
  }