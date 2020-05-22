class Test
{
    private static Integer sum(Function<Integer, Integer> func, int a, int b) {
        if (a>b)
            return 0;
        else return func.apply(a) + sum(func,a+1,b);
    }

    private static Integer cube(Integer a) {
        return a * a * a;
    }

    public static void main (String[] args) throws java.lang.Exception
    {

        Function<Integer,Integer> single = a -> a;
        Function<Integer,Integer> square = a -> a * a;
        Function<Integer,Integer> cube = Test::cube;

        // You can not do the sum in-line without pain due to its recursive nature.
        Sum sum = Test::sum;

        BiFunction<Integer, Integer, Integer> sumOfIntegers = (a, b) -> sum.apply(single, a, b);
        BiFunction<Integer, Integer, Integer> sumOfSquares = (a, b) -> sum(square, a, b); // You could just use the static method directly. 
        BiFunction<Integer, Integer, Integer> sumOfCubes = (a, b) -> sum(cube, a, b);

        System.out.println(sumOfIntegers.apply(1,4));
        System.out.println(sumOfSquares.apply(1,4));
        System.out.println(sumOfCubes.apply(1,4));
    }


}