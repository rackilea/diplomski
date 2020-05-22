import java.util.ArrayList;
import java.util.List;

public class WhySimpler
{
    public static void main(String[] args)
    {
        List<Float> floats = new ArrayList<Float>();

        // This is not possible
        //List<Number> numbers = floats;

        // Let's enforce it with a brutal cast:
        List<Number> numbers = (List<Number>)(Object)floats;

        Integer integer = 123;

        // This is possible, because Integer is a Number: 
        numbers.add(integer);

        // Now, we ended up placing an Integer into a list that
        // may only contain Float values.
        // So this will cause a ClassCastException:
        Float f = floats.get(0);

    }
}