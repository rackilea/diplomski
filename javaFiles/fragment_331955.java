private static int lfsr = 1; // start register in non-zero state
private static final int MASK = 0x2015; // this mask value will generate numbers from 1 to 16383; see http://users.ece.cmu.edu/~koopman/lfsr/ for more
private static int remainingIDs = 10000;
public static synchronized String generateUniqueLogID() {
    if (remainingIDs == 0) throw new RuntimeException("Out of IDs!");
    remainingIDs--;
    do {
        lfsr = ((lfsr & 1) != 0) ? ((lfsr >>> 1) ^ MASK) : (lfsr >>> 1);
    } while (lfsr > 10000); // loop to exclude the unwanted (overlarge) numbers
    int id = lfsr - 1; // subtract one so we generate 0 to 9999 rather than 1 to 10000
    return String.format("%04d", id);
}