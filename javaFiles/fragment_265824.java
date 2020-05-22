public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(1,2,3,4,5);
    List<Integer> list2 = Arrays.asList(6,7,8);
    List<Integer> list3 = Arrays.asList(9,0);
    System.out.println(interleave(Arrays.asList(list1, list2, list3))); // [1, 6, 9, 2, 7, 0, 3, 8, 4, 5]
}