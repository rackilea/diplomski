static void process(int[] subset) {
    System.out.println(Arrays.toString(subset));
}


public static void main(String[] args) throws Exception {
    int[] set = {1,2,3,4,5};
    processSubsets(set, 3);
}