public static void main(String[] args) throws Exception {
    List<LocalDate> list1 = new LinkedList<>();
    list1.add(new LocalDate("112233"));
    list1.add(new LocalDate("223344"));

    List<LocalDate> list2 = new LinkedList<>();
    list2.add(new LocalDate("112233"));
    list2.add(new LocalDate("112233"));

    System.out.println("list1 = " + list1);
    System.out.println("list2 = " + list2);

    System.out.println("list1.containsAll(list2) = " + list1.containsAll(list2));
    System.out.println("list2.containsAll(list1) = " + list2.containsAll(list1));
}