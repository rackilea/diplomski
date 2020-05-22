public static void main(String[] args) {
    String[] a = {"A11","A10", "A1" ,"A2", "A3", "A4"};

    Arrays.sort(a,new CustomComparator());
    System.out.println(Arrays.asList(a).toString());
}