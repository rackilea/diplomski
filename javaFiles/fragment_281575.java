public static void main(String[] args) {
    int [] array=new int[] {1,1,4,4,4,5,5,5,5,7,8,8,8,8,9};
    // replace the next line with sth else to get the max of the array.
    int max = Arrays.stream(array).max().getAsInt();
    int[] res = new int[max + 1];
    for (int i = 0; i < res.length; i++) {
        res[i] = 0;
        for (int anArray : array) {
            res[i] += anArray == i ? 1 : 0;
        }
    }
    /* for (int re : res) {
        System.out.println(re);
    } */
}