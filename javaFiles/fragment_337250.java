import org.apache.xerces.impl.dv.InvalidDatatypeValueException;
import org.apache.xerces.impl.dv.xs.YearDV;

public class Main {

public static void main(String[] args)  {
    try {
        new YearDV().getActualValue("Notayear", null);
        System.out.println("OK");
    } catch (InvalidDatatypeValueException e) {
        System.out.println(e.getMessage());
    }
}