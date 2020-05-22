public class FortyToMPH 
{ 
    public static void main (String args []) 
    {
        double yards, foot, feetLength; 
        double fortyTime = 4.96, minutes, secondsPerMile, mph; 
        int    counter = 0;
        /**
         * Constants.
         */    
        final double FEET_IN_MILES    = 5280;
        final double SECONDS_PER_HOUR = 3600;
        final double DELTA   = 0.01; 
        final double END     = 7.99;

        while (fortyTime <= END)
        {
            yards = 40; // length in yards
            foot  = yards * 3; // convert to feet

            feetLength = FEET_IN_MILES / foot; // You divide the Feet in Miles by the feet conversion of 40 yards

            secondsPerMile = feetLength * fortyTime;
            mph = SECONDS_PER_HOUR / secondsPerMile;
            System.out.format("%.2f 40 Time is %.2f Miles Per Hour%n", fortyTime, mph);

            counter++;
            // every 10th line, print a blank line
            if(counter == 10) {
                System.out.println();
                counter = 0; // reset the line counter 
            }

            fortyTime += DELTA;
        }
    }
}