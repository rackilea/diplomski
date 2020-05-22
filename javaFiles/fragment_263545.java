public static void main(String[] args) {
    Random rnd = new Random();
    List<Integer> myInteger = new ArrayList<Integer>();
    for (int i = 0; i < 10; i++) {
        myInteger.add(rnd.nextInt(10));
    }
    // the list
    System.out.println(myInteger);
    // the list sorted
    Collections.sort(myInteger);
    System.out.println(myInteger);
    // the list inverted
    Collections.reverse(myInteger);
    System.out.println(myInteger);
}