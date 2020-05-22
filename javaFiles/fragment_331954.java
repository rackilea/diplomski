private static final int[] ids = new int[10000];
private static int remainingIDs = ids.length;
static {
    for (int i = 0; i < ids.length; i++) ids[i] = i;
}
private static final Random random = new Random();
public static synchronized String generateUniqueLogID() {
    if (remainingIDs == 0) throw new RuntimeException("Out of IDs!");
    int index = random.nextInt(remainingIDs);
    int id = ids[index];
    ids[index] = ids[--remainingIDs];
    return String.format("%04d", id);
}