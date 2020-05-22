public class Test {
    private static final double EPSILON = 0.00001;
    public static boolean isEqual( double a, double b){

        return (Math.abs(a - b) < EPSILON);

    }


    public static void main(String[]args)
    {

        double ran = 100 + (int)(Math.random() * 100000.999999999);
        int count = 0;              
        double tmpPay = 3666.545;
        double top = tmpPay;
        double low = 0;             

        while ( !isEqual(tmpPay, ran))
        {
            if ( tmpPay > ran)
            {
                if( isEqual(low, 0.0))
                {
                        tmpPay = top / 2;
                        top = tmpPay;
                }
                else
                {
                    tmpPay = tmpPay - ((top - low) / 2);
                    top = tmpPay;
                }        
            }           

            if (tmpPay  < ran)
            {
                tmpPay = top * 1.5;
                low = top;
                top = tmpPay;                   
            }
            System.out.println("RAN:"+ran+" tmpPay:"+tmpPay+" top:"+top+" low:"+low+" counter:"+count);
            count++;
        }
        System.out.println(" VAlue of RAN: " +ran + "----VALUE OF tmpPay: " + tmpPay + "---------- COUNTER: " + count);




    }
}