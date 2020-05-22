package complex;
import java.util.List;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexFormat;
public class Do 
{
  public static void main(String[] args) 
  {
    ComplexFormat complexFormat = new ComplexFormat();
    Complex r = new Complex(6.3,9.6);
    List<Complex> list = r.nthRoot(8);
    for (Complex c : list)
    {
        System.out.println(complexFormat.format(c));
    }
  }
}