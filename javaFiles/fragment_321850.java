import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TargetTypeInferenceTest
{
    public static void main(String[] args)
    {

        Integer[] integers = { 3, 5, 8 };
        Set<Integer> s1 = new HashSet<Integer>(Arrays.asList(integers));

        Double[] doubles = { 3.5, 5.5, 8.5 };
        Set<Double> s2 = new HashSet<Double>(Arrays.asList(doubles));

        Set<Number> res1 = union(s1, s1); // ->it does compile ;-)
        Set<Number> res2 = union(s1, s2); // ->it does compile ;-)
    }

    static <E, F extends E, G extends E> Set<E> union(Set<F> s1, Set<G> s2)
    {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }
}