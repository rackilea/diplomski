public static void main(String[] args) throws Exception {

    final List<Integer> numbers = new ArrayList<Integer>() {
        {
            add(3);
            add(4);
            add(6);
            add(1);
            add(9);
        }

    };

    final int min = findSmallest(numbers.iterator(), Integer.MAX_VALUE);
    System.out.println("Smallest: " + min);
}

private static int findSmallest(Iterator<Integer> iterator, Integer max) {

    int min = Math.min(iterator.next(), max);
    if (iterator.hasNext()) {
        min = findSmallest(iterator, min);
    }

    return min;
}