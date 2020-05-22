public static void main(String... args) {
    Map<Integer, Set<Integer>> numMap = new HashMap<Integer, Set<Integer>>();

    Set<Integer> set = new HashSet<Integer>();
    set.add(10);

    numMap.put(0, set);

    System.out.println("Map before adding is " + numMap);

    set.add(20);

    System.out.println("Map after adding is " + numMap);
}