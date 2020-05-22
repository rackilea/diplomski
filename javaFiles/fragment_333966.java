/*
Separate classes must be in the same directory as main method or must invoke 
classpath
*/
public class Charge {
    // first declare instance variables which are usually private
    private final double rx;
    private final double ry;
    private final double q;

    /* A class contains constructors that are invoked to create objects from a 
    class blueprint. Constructor declarations look like method declarations 
    -except that they use the name of the class and have no return type.  
    Constructors must use the exact name of the class, case sensitive.
    Classes and Constructors are capitalized - methods are camelCase.
    */

    // Constructor
    public Charge(double x0, double y0, double q0) {
        rx = x0;
        ry = y0;
        q = q0;
    }

    /*
    The method to compute electrical potential which is defined by the equation
    V = kq/r
    */
    public double potentialAt(double x, double y) {
        double k = 8.99e09;  // Electrostatic Constant that k=8.99 X 10^9 Nm^2/C^2 (N = Newtons, m = meters, C = Coloumbs)
        // r = delta x - delta y
        double dx = x - rx; // delta x for distance
        double dy = y - ry; // delta y for distance
        return k*q/Math.sqrt(dx*dx + dy*dy); // Computation using distance formula
    }
}