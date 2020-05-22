public static void main(String args[]) throws InterruptedException {
    ArrayList<BigInteger> tree = new ArrayList<BigInteger>();
    tree.add(BigInteger.valueOf(2));
    System.out.println(1);
    while (true) {
        // Store a snapshot of the current tree so new branches created don't mess with
        // the iteration process.
        BigInteger[] originalTree = tree.toArray(new BigInteger[tree.size()]);

        // Keep track of new branches added during each step for index alignment in
        // the stepping method.
        int newBranchCount = 0;

        // Iterate over the values of the original tree.
        for(int i = 0; i < originalTree.length; i++) {
            // Evaluate branch
            stepBranch(tree, originalTree[i], i + newBranchCount);

            // Update branch count after step.
            newBranchCount = tree.size() - originalTree.length;
        }
    }
}

/*
 * Given the tree to mutate, a value from a mutation free version of the tree,
 * and the current working index of the tree:
 * Evaluate whether or not to add a new odd valued branch and report new value(s).
*/
public static void stepBranch(ArrayList<BigInteger> tree, BigInteger branch, int index) throws InterruptedException {

    // If (n + 1) is divisible by three, do so and create a new branch to store the new value
    if (branch.subtract(BigInteger.ONE).mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO)) {

        // If the input is 4, the output is 1 which appears earlier, therefore requires no attention.
        if(!branch.equals(BigInteger.valueOf(4))) {
            // Create new value. 
            BigInteger odd = branch.subtract(BigInteger.ONE).divide(BigInteger.valueOf(3));

            // If the output is even, it doesn't fit the requirements for an odd cell.
            if(!odd.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                tree.add(index + 1, odd);
                System.out.println(tree.get(index + 1));
            }
        } else {
            System.out.println(1);
        }
        Thread.sleep(500);
    }

    // The original branch, not considering a new branch if one was created, is
    // multiplied by 2 so as to check for a new odd node in the next iteration.
    tree.set(index, branch.multiply(BigInteger.valueOf(2)));
    System.out.println(tree.get(index));
    Thread.sleep(500);
}