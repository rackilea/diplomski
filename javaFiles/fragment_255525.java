public class Complex {

...

public boolean equals (Object obj) {
    if (obj instanceof Complex) {    // you first need to check whetever the obhect passed to the equal method is indeed of type "Complex" because i guess what you want here is to compare two Complex objects.
        Complex c =  (Complex) obj   // If the object is complex then you need to treat it as complex so cast it to Complex type in order to compare the "real" and "imag" values of the object.
        return (real == c.real) && (imag == c.imag); 
        // I'm guessing real means [this].real
        // yes, it does.
    }
    return false;
}