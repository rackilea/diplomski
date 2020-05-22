public class RootFinder {

    // Method to be called to calculate the root 

    public void InvokeNewton(){
        double del = 1e-10;                                  // Delta or precision; 
        double xx = 0 ;                                      // Storage for previous root

        double dx = 0;                                       // Storage to hold a derivative of a pre-defined function;
        double x= Math.sqrt(beta/alpha);                     // Initial guess;

        while (Math.abs(xx-x) >= del &&  f(x)!= 0.0) {       // Math.abs(xx-x) - Estimated error;
            dx = f(x)/d(x);                                  // Derivative
            xx=x;                                            // New xx value set to previous root for compersion;
            x = x - dx;                                      // Root obtained;
        }
    }// Method to provide function f(x)
                          // !!! Provide your function bellow !!!
    public double f(double x) {
        return (alpha * (Math.pow(x,5.0/3.0)) + 0.2*(Math.pow(x,2.0/3.0)) - beta);
    }

    // Method to provide the derivative f'(x).
                          // !!!Provide the prime derivative of your function bellow!!!
    public double d(double x) {
        return (0.04*Math.pow(jf.getSourceDiameter(),1.0/3.0)*Math.pow(x,2.0/3.0)) / Math.pow(jf.getJetVelocity(),2.0/3.0) + 2.0 /  15.0*Math.pow(x,1.0/3.0);
    }
}