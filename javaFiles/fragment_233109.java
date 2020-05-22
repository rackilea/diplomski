import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Program
{
    static <T> List<T> alternateElementsBynStep (List<? extends T> flist, List<? extends T> slist, int n)
    {
        class Wrapper implements Comparable<Wrapper>
        {
            int position;
            T value;

            Wrapper (int position, T value)
            {
                this.position = position;
                this.value = value;
            }

            T getValue ()
            {
                return value;
            }

            @Override
            public int compareTo(Wrapper o) {
                return Integer.compare(position, o.position);
            }
        }

        Function<List<? extends T>, Stream<? extends Wrapper>> wrap =
            seq ->  IntStream.range(0, seq.size())
                        .mapToObj(i -> new Wrapper(i / n, seq.get(i)))
        ;

        return Stream.concat(wrap.apply(flist), wrap.apply(slist))
            .sorted()
            .map(Wrapper::getValue)
            .collect(Collectors.toList())
        ;
    }

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(alternateElementsBynStep(Arrays.asList(1, 2, 3, 4), Arrays.asList(10, 11, 12, 13, 14, 15, 16, 17), 2).toArray()));

        // output: [1, 2, 10, 11, 3, 4, 12, 13, 14, 15, 16, 17]
    }
}