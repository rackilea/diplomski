public static void get_factors(int num) {
    factorList = new ArrayList<Integer>();
    for (int i = 2; i < num; i++) {
        if (num % i == 0) {
            factorList.add(i);
        }            
    }
}