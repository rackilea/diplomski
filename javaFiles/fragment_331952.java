private static final Random random = new Random();
private static final HashSet<Integer> previousIDs = new HashSet<>();
public static synchronized String generateUniqueLogID() {
    if (previousIDs.size() == 10000) throw new RuntimeException("Out of IDs!");
    int id;
    do {
        id = random.nextInt(10000);
    } while (!previousIDs.add(id));
    return String.format("%04d", id);
}