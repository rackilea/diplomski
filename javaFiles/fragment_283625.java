public static void main(String[] args) {
    List<Integer> input = Arrays.asList(60, 60, 1, 4, 5, 7, 60);

    Map<Integer, List<Integer>> result = new HashMap<>();

    for (int n = 0; n < input.size(); ++n) {
        List<Integer> list = result.get(input.get(n));

        if (list != null) {             
            list.add(n);
        } else {
            list = new ArrayList<>();
            list.add(n);
            result.put(input.get(n), list);
        }
    }

    System.out.println(result); // prints {1=[2], 4=[3], 5=[4], 7=[5], 60=[0, 1, 6]}
}