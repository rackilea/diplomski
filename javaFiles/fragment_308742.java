public static void main(String args[]) {
    iterate(new String[][]{{"a","b","c"},{"d","e"},{"f","g","h","i"}});
}
static void iterate(String[][] jagged) {
    int count = 1;
    int[] divisors = new int[jagged.length];
    for (int j = 0; j < jagged.length; j++) {
        divisors[j] = count;
        count *= jagged[j].length;
    }
    for (int i = 0; i < count; i++) {
        String[] combination = new String[jagged.length];
        for (int j = 0; j < jagged.length; j++) {
            int mod = jagged[j].length;
            combination[j] = jagged[j][(i/divisors[j])%mod];
        }
        process(combination);
    }
}
static void process(String[] combination) {
    System.out.println(Arrays.toString(combination));
    // Do whatever you want here. Process as you go to save memory,
    // or add to a list to process later.
}