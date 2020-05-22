public static double acos(double a)
{
    final double epsilon=1.0E-7; 
    double x=a;
    do {
        x-=(Math.sin(x)-a)/Math.cos(x);
    }
    while (Math.abs(Math.sin(x)-a)>epsilon);

    // returned angle is in radians
    return -1*(x-Math.PI/2);
}