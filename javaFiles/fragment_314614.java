private static void helper1(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
    // add by duplicating the provided list
    result.add(new ArrayList<Integer>(list));
}

private static void helper2(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
    // add provided list as is
    result.add(list);
}

public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    ArrayList<Integer> list1 = new ArrayList<>();
    list1.add(10);
    helper1(result, list1);

    ArrayList<Integer> list2 = new ArrayList<>();
    list2.add(20);
    helper2(result, list2);

    System.out.println(result); // [[10], [20]]

    list1.add(11);
    list2.add(21);

    System.out.println(result); // [[10], [20, 21]]
}