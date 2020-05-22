static void printSubsets(int[] set) {

    long total = 0;

    for (int bit=1; bit!=0; bit<<=1) {

        int numbersWithBitSet = 0;
        for (int i : set) {
            if ((i&bit)!=0) numbersWithBitSet++;
        }

        long subsets = (1L<<numbersWithBitSet)-1;
        total += bit * subsets;
    }

    System.out.println("Result: " + total);
}