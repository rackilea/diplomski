package javaapplication38;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class JavaApplication38
{

    public static void main(String[] args)
    {        
        new Engine(BigInteger.TEN.pow(2)).start();
    }

    public static class Engine
    {        
        final BigInteger radius    ;
        final BigInteger negRadius ;
        final BigInteger r2        ; //The force awakens on December 18, 2015.

        public static final BigInteger TWO = new BigInteger("2");    

        public Engine(BigInteger radius)
        {
            this.radius = radius;
            negRadius   = radius.negate();
            r2          = this.radius.pow(2);
        }

        public Engine(int radius)
        {
            this(new BigInteger("" + radius));
        }      

        public void start()
        {
            Runnable r = new Runnable()
            {
                public void run()
                {                    
                    BigInteger area = BigInteger.ZERO; //area of the circle

                    //calculate circle's area
                    //let's walk through all the points (x;y)
                    for (BigInteger x = new BigInteger(negRadius.toString());
                            x.compareTo(radius) <= 0; 
                            x = x.add(BigInteger.ONE))
                    {                        
                        for (BigInteger y = new BigInteger(negRadius.toString());
                                y.compareTo(radius) <= 0;
                                y = y.add(BigInteger.ONE))
                        {
                            //System.out.format("Point %s, %s%n", x.toString(), y.toString());
                            //if square is in the circle add square's area to the area of the circle
                            if (x.pow(2).add(y.pow(2)).compareTo(r2) <= 0)
                            {
                                area = area.add(BigInteger.ONE);
                            }                            
                        }                        
                    }                    
                    System.out.println("Radius " + radius.toString());
                    System.out.println("Area " + area.toString());                    
                    System.out.println("PI   " + new BigDecimal(area).divide(new BigDecimal(r2)));                                                             
                }
            };
            new Thread(r).start();
        }
    }
}