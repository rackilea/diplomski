public static void main(String[] args) {
    Set<Integer> s = new HashSet<Integer>(); // create a set
    Random r = new Random();
    while (s.size() < 20) {
        s.add(r.nextInt(100)+1);  // add elements to set upto size =20
    }
    Integer[] array = new Integer[20];
    s.toArray(array); // convert set to array of Integers
    System.out.println(Arrays.toString(array));

}