public static void main(String... args) {
    List<Integer> a1 = Arrays.asList(5, 10, 20, 50, 100, 500, 1000);
    Set<Integer>  a2 = new HashSet<Integer>(Arrays.asList(50, 500, 1000));

    ArrayList<Integer> a3 = new ArrayList<Integer>();                

    for (Integer a : a1)
        a3.add(a2.contains(a) ? 1 : 0);

    System.out.println(a3);
}