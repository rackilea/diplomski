public class Test {
    List<String> testStrings = Arrays.asList(new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"});
    List<Integer> testNumbers = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

    static <T extends Comparable<T>> List<Integer> getSortOrder(List<T> list) {
        // Ints in increasing order from 0. One for each entry in the list.
        List<Integer> order = IntStream.rangeClosed(0, list.size() - 1).boxed().collect(Collectors.toList());
        Collections.sort(order, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // Comparing the contents of the list at the position of the integer.
                return list.get(o1).compareTo(list.get(o2));
            }
        });
        return order;
    }

    static <T> List<T> reorder(List<T> list, List<Integer> order) {
        return order.stream().map(i -> list.get(i)).collect(Collectors.toList());
    }

    public void test() {
        System.out.println("The strings: " + testStrings);
        List<Integer> sortOrder = getSortOrder(testStrings);
        System.out.println("The order they would be if they were sorted: " + sortOrder + " i.e. " + reorder(testStrings, sortOrder));
        List<Integer> reordered = reorder(testNumbers, sortOrder);
        System.out.println("Numbers in alphabetical order of their names: " + reordered);
    }

    public static void main(String[] args) {
        new Test().test();
        System.out.println("Hello");
    }
}