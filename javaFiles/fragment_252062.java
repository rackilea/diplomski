static boolean existsx(double p1x, double p2x,double[] varray){
    double upperBound = Math.max(p1x, p2x);
    double lowerBound = Math.min(p1x, p2x);

    for (double number : varray)
    {
       if ( (number <= upperBound) && (number >= lowerBound))
       {
           return true;
       }
    }

    return false;
}