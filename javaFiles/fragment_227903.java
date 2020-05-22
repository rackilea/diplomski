public static void main(String [] args)
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i < 6; ++i) list.add(i);
    System.out.println("1### " + list);
    System.out.println("2### " + getSubArraysOf(list));
}

private static List<Integer> getSubArraysOf(List<Integer> array) {

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < array.size(); ++i) {
        result.addAll(array.subList(0, array.size() - i));
    }
    return result;
}