Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();

for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
    System.out.println("Map values for key \"" + entry.getKey() + "\":");
    for (Integer value : entry.getValue() == null ? new ArrayList<Integer>() : entry.getValue()) {
        System.out.print(value + " ");
    }
    System.out.println();
}