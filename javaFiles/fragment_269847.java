List<List<Long>> cells = new ArrayList<>();
cells.add(Arrays.asList(1L, 0L));
cells.add(Arrays.asList(1L, 1L));
cells.add(Arrays.asList(1L, 2L));

for (long i = 0L; i < 3; i++) {
    for (long j = 0L; j < 3; j++) {
        if (cells.contains(Arrays.asList(i, j))) {
            System.out.println("Contains: " + i + ", " + j);
        }
    }
}