public static void main(String[] args) {
    String[] strings = { "A", "man", "a", "plan", "a", "canal", "Panama" };

    List<String> output = new ArrayList<String>();
    for (List<String> partition : partition(Arrays.asList(strings), 3)) {
        output.add(String.join(" ", partition));
    }
    System.out.println(Arrays.toString(output.toArray()));
}

private static <T> List<List<T>> partition(List<T> input, int size) {
    List<List<T>> lists = new ArrayList<List<T>>();
    for (int i = 0; i < input.size(); i += size) {
        lists.add(input.subList(i, Math.min(input.size(), i + size)));
    }
    return lists;
}