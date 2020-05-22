import javax.measure.Measure;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Length;
import javax.measure.quantity.Quantity;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;


public class JScienceUnits
{
    public static void main(String[] args)
    {
        final Unit<Angle> rev = NonSI.REVOLUTION.times(Math.PI * 2);
        final Unit<Length> cm = SI.CENTI(SI.METER);

        final Unit<? extends Quantity> cm3rev = cm.pow(3).divide(rev);
        final Unit<Length> mm = SI.MILLI(SI.METER);

        //double d1 = 4.44 cm3rev;
        Measure<Double, ? extends Quantity> d1 = Measure.valueOf(4.44, cm3rev);

        //double d2 = 2.22 mm;
        Measure<Double, Length> d2 = Measure.valueOf(2.22, mm);

        //double d = d1/d2;
        Unit<? extends Quantity> resultUnit = cm3rev.divide(mm);
        Measure<?, ?> result = Measure.valueOf(d1.getValue() / d2.getValue(), resultUnit);

        System.out.println("resultUnit "+resultUnit);
        System.out.println("result "+result);
    }
}