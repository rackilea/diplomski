public static void main(String[] args) throws Exception {
    ArrayList<long[]> dp = new ArrayList<>();
    // add 3 arrays
    for (int i = 0; i < 3; i++) {
        dp.add(new long[] { 1L, 2L, 3L });
    }
    // add a new array of size 5
    dp.add(new long[5]); //all are by defaul 0
    // get the info from array
    for (long[] ls : dp) {
        for (long l : ls) {
            System.out.println("long:" + l);
        }
        System.out.println("next element in the list");
    }
}