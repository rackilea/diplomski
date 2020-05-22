public static double myCos(double x) {
    // Cosine is symmetric around the Y axis: get rid of the sign.
    x = Math.abs(x);

    // Calculate the number of times 2*PI fits in x
    double y = Math.floor(x / (Math.PI * 2));

    // and subtract that many 2*PI
    x -= y * Math.PI * 2;
    // x is now within 0 and 2*PI.

    // The PI..2PI range is the negated version of 0..PI.
    double sign = 1;
    if ( x > Math.PI ) {
       sign = -1;
       // mirror x in the line x=Math.PI:
       x =  - x + Math.PI; // or: Math.PI * 2 - x
    }

    /* cosine approximation ... */

    return alteSumme * sign;
}