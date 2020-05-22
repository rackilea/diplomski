public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> subList = new ArrayList<>();
    subList.add(1);
    subList.add(2);
    list.add(subList);
    subList = new ArrayList<>();
    subList.add(3);
    subList.add(4);
    list.add(subList);
    System.out.println(list);
}