private static final Set<Long> usedIds = new HashSet<> ();
public static synchronized long getUniqueId() {
    long millis;
    do {
        millis = System.currentTimeMillis();
    } while (!usedIds.add(millis));
    return millis;
}