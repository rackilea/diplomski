import java.util.Arrays;

public class OneLineFizzBuzz
{
    public static void main(String[] args)
    {
        OneLineFizzBuzz f = new OneLineFizzBuzz();
        String[] result = f.fizzBuzz(1000, 1006);
        System.out.println(Arrays.toString(result));

        check(f.fizzBuzz(1, 6), new String[]{"1", "2", "Fizz", "4", "Buzz"});
        check(f.fizzBuzz(1, 8), new String[]{"1", "2", "Fizz", "4", "Buzz", "Fizz", "7"});
        check(f.fizzBuzz(1, 11), new String[]{"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"});
        check(f.fizzBuzz(1, 16), new String[]{"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"});
        check(f.fizzBuzz(1, 4), new String[]{"1", "2", "Fizz"});
        check(f.fizzBuzz(1, 2), new String[]{"1"});
        check(f.fizzBuzz(50, 56), new String[]{"Buzz", "Fizz", "52", "53", "Fizz", "Buzz"});
        check(f.fizzBuzz(15, 17), new String[]{"FizzBuzz", "16"});
        check(f.fizzBuzz(30, 36), new String[]{"FizzBuzz", "31", "32", "Fizz", "34", "Buzz"});
        check(f.fizzBuzz(1000, 1006), new String[]{"Buzz", "1001", "Fizz", "1003", "1004", "FizzBuzz"});
        check(f.fizzBuzz(99, 102), new String[]{"Fizz", "Buzz", "101"});
        check(f.fizzBuzz(14, 20), new String[]{"14", "FizzBuzz", "16", "17", "Fizz", "19"});        
    }
    private static void check(String[] fizzBuzz, String[] strings)
    {
        boolean passed = Arrays.equals(fizzBuzz, strings);
        System.out.println(Arrays.toString(fizzBuzz) + " passed? " + passed);
        if (!passed)
        {
            System.out.println("Whoopsie...");
        }
    }

    public String[] fizzBuzz(int start, int end)
    {
        return (start == end ? ""
            : (start % 15 == 0 ? "FizzBuzz"
                : start % 3 == 0 ? "Fizz"
                    : start % 5 == 0 ? "Buzz" : String.valueOf(start))
                + Arrays.toString(fizzBuzz(start + 1, end)))
                    .replaceAll("\\]", "").split("\\[|,\\s*");
    }
}