public static void main(String[] args) throws IOException {
    List<Number> list = new ArrayList<Number>();
    list.add(0);
    list.add(1);
    list.add(2);
    printCombinations(new ArrayList<Number>(), list, 0);
}

public static void printCombinations(List<Number> done, List<Number> numbers, int depth) {
    if (numbers.size() <= depth) {
        System.out.println(done); // replace with something better
    } else {
        for (Number r : numbers) {
            List<Number> newDone = new ArrayList<Number>(done);
            newDone.add(r);
            printCombinations(newDone, numbers, depth + 1);
        }
    }
}