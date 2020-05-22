List<Long> durations = new ArrayList<>(hashCodes.size());
for (int n : hashCodes) {
    long start = System.nanoTime();
    hashCodes.contains(n); // true
    long end = System.nanoTime();
    durations.add(end - start);
}