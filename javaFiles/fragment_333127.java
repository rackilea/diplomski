public class Sol {

    public static void main(String[] args) {
        Sol.approxEqual(1.0,1.2)
    }

    public static boolean approxEqual (double x, double y)
    {
        //Judge where two numbers are close enough (equal)
        final double EPSILON = 1E-10;
        if (Math.abs(x-y)<EPSILON)
        {
            return(true);
        }
        return(false);
    }
}