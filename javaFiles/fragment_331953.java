private static final Random random = new Random();
private static final BitSet previousIDs = new BitSet();
private static int remainingIDs = 10000;
public static synchronized String generateUniqueLogID() {
    if (remainingIDs == 0) throw new RuntimeException("Out of IDs!");
    int id;
    do {
        id = random.nextInt(10000);
    } while (previousIDs.get(id));
    previousIDs.set(id);
    remainingIDs--;
    return String.format("%04d", id);
}