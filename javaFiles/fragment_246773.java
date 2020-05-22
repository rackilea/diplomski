AtomicInteger atomicInteger = new AtomicInteger(0);
Map<String, Integer> known = new ConcurrentHashMap<>();
Path path = Paths.get("./myFile.txt");
int[][] array = Files.lines(path)
    .map(s -> s.split("\\s+", 2))
    .map(a -> new int[]{
        known.computeIfAbsent(a[0],
                k -> atomicInteger.getAndIncrement()),
        Integer.parseInt(a[1])
    })
    .toArray(int[][]::new);