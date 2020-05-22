/* Used to generate and encapsulate pairwise independent hash functions.
See see https://people.csail.mit.edu/ronitt/COURSE/S12/handouts/lec5.pdf , claim 5 for more information.
 */
private static class HashF {

    private final int a;
    private final int b;
    private final int p = 1610612741; // prime

    HashF(int a, int b) {
        Random rand = new Random();

        this.a = rand.nextInt(p);
        this.b = rand.nextInt(p);
    }

    // hashes integers
    public int hash(int x) {
        return (a*x + b) % p;
    }

}