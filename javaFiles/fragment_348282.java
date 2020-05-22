public class HigherOrder {

        public static void main(String[] args) {
            Function<Integer, Long> addOne = add(1L);

            System.out.println(addOne.apply(1)); //prints 2

            Arrays.asList("test", "new")
                    .parallelStream()  // suggestion for execution strategy
                    .map(camelize)     // call for static reference
                    .forEach(System.out::println);
        }

        private static Function<Integer, Long> add(long l) {
            return (Integer i) -> l + i;
        }

        private static Function<String, String> camelize = (str) -> str.substring(0, 1).toUpperCase() + str.substring(1);
    }