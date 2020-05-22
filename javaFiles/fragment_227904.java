public static void main(String [] args)
    List<Integer> list = new ArrayList<>();
    list.add(5);
    System.out.println("1### " + list);
    System.out.println("2### " + getSubArraysOf(list));
}

private static List<Integer> getSubArraysOf(List<Integer> array) {

    int lastItem = array.get(array.size() - 1);
    if (lastItem == 1) return array;
    array.add(--lastItem);
    return getSubArraysOf(array);
}