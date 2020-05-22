public class HashComparative implements Callable<String> {
    private final String enteredHash;
    private final int lengthOfPass;

    public HashComparative(final String enteredHash, final int lengthOfPass) {
        this.enteredHash = enteredHash;
        this.lengthOfPass = lengthOfPass;
    } 
    @Override
    public String call() throws Exception {
        //CODE WILL GO HERE TO COMPUTE HASHES
        return h;
    }
    ...
}