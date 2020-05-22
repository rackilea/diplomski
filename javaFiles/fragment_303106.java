public static Integer[] readFileReturnIntegers(Scanner sc) {
    List<Integer> list = new ArrayList<Integer>();
    while (sc.hasNextInt()) {
        list.add(sc.nextInt());
    }
    return list.toArray(new Integer[list.size()]);
}